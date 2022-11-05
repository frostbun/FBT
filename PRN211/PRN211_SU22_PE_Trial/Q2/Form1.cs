using Q2.Models;

namespace Q2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        void LoadData()
        {
            using var ctx = new PE_PRN_Sum21Context();
            var data = ctx.Employees.ToList();
            dgEmployee.DataSource = data;

            txtName.DataBindings.Clear();
            txtName.DataBindings.Add("Text", data, "EmployeeName");

            rbtnMale.DataBindings.Clear();
            rbtnMale.DataBindings.Add("Checked", data, "Male");

            nmSalary.DataBindings.Clear();
            nmSalary.DataBindings.Add("Value", data, "Salary");

            txtPhone.DataBindings.Clear();
            txtPhone.DataBindings.Add("Text", data, "Phone");
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            LoadData();
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            using var ctx = new PE_PRN_Sum21Context();
            ctx.Employees.Add(new Employee()
            {
                EmployeeName = txtName.Text,
                Male = rbtnMale.Checked,
                Salary = (float)nmSalary.Value,
                Phone = txtPhone.Text
            });
            ctx.SaveChanges();
            LoadData();
        }

        private void btnUpdate_Click(object sender, EventArgs e)
        {
            using var ctx = new PE_PRN_Sum21Context();
            var id = (int)dgEmployee.CurrentRow.Cells[0].Value;
            var employee = ctx.Employees.FirstOrDefault(e => e.EmployeeId == id)!;
            employee.EmployeeName = txtName.Text;
            employee.Male = rbtnMale.Checked;
            employee.Salary = (float)nmSalary.Value;
            employee.Phone = txtPhone.Text;
            ctx.Update(employee);
            ctx.SaveChanges();
            LoadData();
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            using var ctx = new PE_PRN_Sum21Context();
            var id = (int)dgEmployee.CurrentRow.Cells[0].Value;
            var employee = ctx.Employees.FirstOrDefault(e => e.EmployeeId == id)!;
            ctx.Remove(employee);
            ctx.SaveChanges();
            LoadData();
        }

        private void rbtnMale_CheckedChanged(object sender, EventArgs e)
        {
            rbtnFemale.Checked = !rbtnMale.Checked;
        }
    }
}
