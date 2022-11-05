using FinalProject.Models;
using Microsoft.EntityFrameworkCore;
using System.Text.RegularExpressions;

namespace FinalProject
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private List<Notification> notifications = new List<Notification>();

        private string SelectedRepeatType
        {
            get
            {
                if (rbtnRepeatTypeNo.Checked)
                {
                    return RepeatType.No;
                }
                if (rbtnRepeatTypeMonthly.Checked)
                {
                    return RepeatType.Monthly;
                }
                return RepeatType.Annually;
            }
        }

        private DateTime SelectedDate
        {
            get { return calendar.SelectionStart.Date; }
        }

        private DateTime SelectedDateTime
        {
            get { return SelectedDate + tpEventTime.Value.TimeOfDay; }
        }

        private int SelectedEventId
        {
            get
            {
                var currentRow = dgEvents.CurrentRow;
                if (currentRow is null) return 0;
                return (int)currentRow.Cells["Id"].Value;
            }
        }

        private int SelectedNotiId
        {
            get
            {
                var currentRow = dgNotis.CurrentRow;
                if (currentRow is null) return 0;
                return (int)currentRow.Cells["Id"].Value;
            }
        }

        private async void LoadEvents()
        {
            using (var ctx = new FinalProjectContext())
            {
                var data = await ctx.Events
                    .Where(evt =>
                        evt.Time.Date == SelectedDate
                        || evt.Repeat == RepeatType.Monthly && evt.Time.Day == SelectedDate.Day
                        || evt.Repeat == RepeatType.Annually && evt.Time.DayOfYear == SelectedDate.DayOfYear)
                    .Select(evt => new
                    {
                        evt.Name,
                        evt.Time,
                        evt.Repeat,
                        evt.Id,
                    })
                    .ToListAsync();
                dgEvents.DataSource = data;
                calendar.RemoveAllBoldedDates();
                calendar.RemoveAllMonthlyBoldedDates();
                calendar.RemoveAllAnnuallyBoldedDates();
                foreach (var evt in await ctx.Events.ToListAsync())
                {
                    switch (evt.Repeat)
                    {
                        case RepeatType.No:
                            calendar.AddBoldedDate(evt.Time);
                            break;
                        case RepeatType.Monthly:
                            calendar.AddMonthlyBoldedDate(evt.Time);
                            break;
                        case RepeatType.Annually:
                            calendar.AddAnnuallyBoldedDate(evt.Time);
                            break;
                    }
                }
            }
            calendar.UpdateBoldedDates();
            BindEvent();
            LoadNotifications();
        }

        private async void LoadNotifications()
        {
            using (var ctx = new FinalProjectContext())
            {
                var data = await ctx.Notifications
                    .Where(noti => noti.EventId == SelectedEventId)
                    .Select(noti => new
                    {
                        Time = (noti.Days == noti.Hours && noti.Hours == noti.Minutes && noti.Minutes == 0) ? "On event" : $"{(noti.Days > 0 ? $"{noti.Days} day(s) " : "")}{(noti.Hours > 0 ? $"{noti.Hours} hour(s) " : "")}{(noti.Minutes > 0 ? $"{noti.Minutes} minute(s) " : "")}before event",
                        noti.Id
                    })
                    .ToListAsync();
                dgNotis.DataSource = data;
                notifications = await ctx.Notifications.Include(noti => noti.Event).ToListAsync();
            }
            BindNotification();
        }

        private void BindEvent()
        {
            var currentRow = dgEvents.CurrentRow;
            if (currentRow == null) return;
            txtEventName.Text = (string)currentRow.Cells["Name"].Value;
            calendar.SelectionStart = (DateTime)currentRow.Cells["Time"].Value;
            tpEventTime.Value = (DateTime)currentRow.Cells["Time"].Value;
            var repeat = (string)currentRow.Cells["Repeat"].Value;
            rbtnRepeatTypeNo.Checked = repeat == RepeatType.No;
            rbtnRepeatTypeMonthly.Checked = repeat == RepeatType.Monthly;
            rbtnRepeatTypeAnnually.Checked = repeat == RepeatType.Annually;
        }

        private void BindNotification()
        {
            var currentRow = dgNotis.CurrentRow;
            if (currentRow == null) return;
            var time = (string)currentRow.Cells["Time"].Value;
            var numbers = Regex.Split(time, @"\D+").Where(s => !string.IsNullOrWhiteSpace(s)).Select(s => int.Parse(s)).ToList();
            var i = 0;
            if (time.Contains("day")) nmDays.Value = numbers[i++];
            if (time.Contains("hour")) nmHours.Value = numbers[i++];
            if (time.Contains("minute")) nmMinutes.Value = numbers[i++];
        }

        private void dgEvents_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            BindEvent();
            LoadNotifications();
        }

        private void dgNotis_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            BindNotification();
        }

        private void calendar_DateSelected(object sender, DateRangeEventArgs e)
        {
            LoadEvents();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            LoadEvents();
            rbtnRepeatTypeNo.Checked = true;
        }

        private async void btnEventAdd_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrWhiteSpace(txtEventName.Text))
            {
                MessageBox.Show("Name can not empty!");
                return;
            }
            using (var ctx = new FinalProjectContext())
            {
                ctx.Events.Add(new Event
                {
                    Name = txtEventName.Text,
                    Time = SelectedDateTime,
                    Repeat = SelectedRepeatType,
                });
                await ctx.SaveChangesAsync();
            }
            LoadEvents();
        }

        private async void btnEventUpdate_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrWhiteSpace(txtEventName.Text))
            {
                MessageBox.Show("Name can not empty!");
                return;
            }
            using (var ctx = new FinalProjectContext())
            {
                var evt = ctx.Events.FirstOrDefault(evt => evt.Id == SelectedEventId);
                if (evt is null) return;
                evt.Name = txtEventName.Text;
                evt.Time = SelectedDateTime;
                evt.Repeat = SelectedRepeatType;
                ctx.Update(evt);
                await ctx.SaveChangesAsync();
            }
            LoadEvents();
        }

        private async void btnEventDelete_Click(object sender, EventArgs e)
        {
            using (var ctx = new FinalProjectContext())
            {
                var evt = ctx.Events.FirstOrDefault(evt => evt.Id == SelectedEventId);
                if (evt is null) return;
                ctx.Remove(evt);
                await ctx.SaveChangesAsync();
            }
            LoadEvents();
        }

        private async void btnNotiAdd_Click(object sender, EventArgs e)
        {
            using (var ctx = new FinalProjectContext())
            {
                var evt = ctx.Events.FirstOrDefault(evt => evt.Id == SelectedEventId);
                if (evt is null) return;
                ctx.Notifications.Add(new Notification
                {
                    Days = (int)nmDays.Value,
                    Hours = (int)nmHours.Value,
                    Minutes = (int)nmMinutes.Value,
                    Event = evt
                });
                await ctx.SaveChangesAsync();
            }
            LoadNotifications();
        }

        private async void btnNotiUpdate_Click(object sender, EventArgs e)
        {
            using (var ctx = new FinalProjectContext())
            {
                var noti = ctx.Notifications.FirstOrDefault(noti => noti.Id == SelectedNotiId);
                if (noti is null) return;
                noti.Days = (int)nmDays.Value;
                noti.Hours = (int)nmHours.Value;
                noti.Minutes = (int)nmMinutes.Value;
                ctx.Update(noti);
                await ctx.SaveChangesAsync();
            }
            LoadNotifications();
        }

        private async void btnNotiDelete_Click(object sender, EventArgs e)
        {
            using (var ctx = new FinalProjectContext())
            {
                var noti = ctx.Notifications.FirstOrDefault(noti => noti.Id == SelectedNotiId);
                if (noti is null) return;
                ctx.Remove(noti);
                await ctx.SaveChangesAsync();
            }
            LoadNotifications();
        }

        private void timer_Tick(object sender, EventArgs e)
        {
            var now = DateTime.Now;
            foreach (var noti in notifications)
            {
                var evt = noti.Event;
                var time = evt.Time
                    .AddDays(-noti.Days)
                    .AddHours(-noti.Hours)
                    .AddMinutes(-noti.Minutes);
                if ((time.Date == now.Date
                    || evt.Repeat == RepeatType.Monthly && time.Day == now.Day
                    || evt.Repeat == RepeatType.Annually && time.DayOfYear == now.DayOfYear)
                    && time.Hour == now.Hour
                    && time.Minute == now.Minute)
                {
                    MessageBox.Show($"{evt.Name} happening {((noti.Days == noti.Hours && noti.Hours == noti.Minutes && noti.Minutes == 0) ? "now" : $"in {(noti.Days > 0 ? $"{noti.Days} day(s) " : "")}{(noti.Hours > 0 ? $"{noti.Hours} hour(s) " : "")}{(noti.Minutes > 0 ? $"{noti.Minutes} minute(s) " : "")}")}");
                }
            }
        }
    }
}
