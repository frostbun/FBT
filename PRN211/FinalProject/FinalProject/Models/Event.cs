using System;
using System.Collections.Generic;

namespace FinalProject.Models
{
    public partial class Event
    {
        public Event()
        {
            Notifications = new HashSet<Notification>();
        }

        public int Id { get; set; }
        public string Name { get; set; } = null!;
        public DateTime Time { get; set; }
        public string Repeat { get; set; } = null!;

        public virtual ICollection<Notification> Notifications { get; set; }
    }
}
