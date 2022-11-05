using System.Data.SqlClient;

namespace WinFormsApp2
{
    public partial class CustomerForm : Form
    {
        DataProvider d = new();

        public CustomerForm()
        {
            InitializeComponent();
        }

        public CustomerForm(string text)
        {
            InitializeComponent();
            this.Text = "Hello " + text;
        }

        private void btExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void CustomerForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            Environment.Exit(0);
        }

        private void btReset_Click(object sender, EventArgs e)
        {
            cbID.Text = "";
            tbName.Text = "";
            tbBirthdate.Text = "";
            tbAddress.Text = "";
            rbMale.Checked = false;
            rbFemale.Checked = false;
        }

        private void CustomerForm_Load(object sender, EventArgs e)
        {
            LoadData();
        }

        private void LoadData()
        {
            try
            {
                string query = "SELECT * FROM Customers";
                var result = d.executeQuery(query);
                dgCustomer.DataSource = result;
                //cbID.DataSource = result;
                //cbID.DisplayMember = "CustomerId";
                //cbID.ValueMember = "CustomerId";
                cbID.Items.Clear();
                using var r = d.executeQuery2(query);
                while (r.Read())
                {
                    cbID.Items.Add(r["CustomerId"]);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Load fail: " + ex.Message);
            }
        }

        private void dgCustomer_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            tbName.Text = dgCustomer.CurrentRow.Cells["CustomerName"].Value.ToString();
            tbBirthdate.Text = dgCustomer.CurrentRow.Cells["Birthdate"].Value.ToString();
            tbAddress.Text = dgCustomer.CurrentRow.Cells["Address"].Value.ToString();
            rbMale.Checked = dgCustomer.CurrentRow.Cells["Gender"].Value is true;
            rbFemale.Checked = dgCustomer.CurrentRow.Cells["Gender"].Value is false;
        }

        private void btAdd_Click(object sender, EventArgs e)
        {
            try
            {
                string stmt = @$"
                    INSERT INTO Customers (CustomerName, Birthdate, Gender, Address)
                    VALUES (N'{tbName.Text}', '{tbBirthdate.Text}', '{rbMale.Checked}', N'{tbAddress.Text}')
                ";
                if (d.executeNonQuery(stmt))
                {
                    MessageBox.Show("Add success");
                    LoadData();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Add fail: " + ex.Message);
            }
        }

        private void cbID_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (cbID.SelectedIndex == -1) return;
            var customer = d.executeQuery($"SELECT * FROM Customers WHERE CustomerId = '{cbID.SelectedItem}'").Rows[0];
            tbName.Text = customer["CustomerName"].ToString();
            tbBirthdate.Text = customer["Birthdate"].ToString();
            tbAddress.Text = customer["Address"].ToString();
            rbMale.Checked = customer["Gender"] is true;
            rbFemale.Checked = customer["Gender"] is false;
        }

        private void btDelete_Click(object sender, EventArgs e)
        {
            if (cbID.SelectedIndex == -1) return;
            //try
            //{
            //    string stmt = $"DELETE FROM Customers WHERE CustomerId='{cbID.SelectedItem}'";
            //    if (d.executeNonQuery(stmt))
            //    {
            //        MessageBox.Show("Delete success");
            //        LoadData();
            //    }
            //}
            //catch (Exception ex)
            //{
            //    MessageBox.Show("Delete fail: " + ex.Message);
            //}
            try
            {
                string stmt = $"DELETE FROM Customers WHERE CustomerId=@id";
                if (d.executeNonQuery(stmt, new SqlParameter("@id", cbID.SelectedItem)))
                {
                    MessageBox.Show("Delete success");
                    LoadData();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Delete fail: " + ex.Message);
            }
        }

        private void btUpdate_Click(object sender, EventArgs e)
        {
            try
            {
                string stmt = @"
                    UPDATE Customers
                    SET CustomerName=@name,
                        Birthdate=@dob,
                        Gender=@gender,
                        Address=@address
                    WHERE CustomerId=@id
                ";
                if (d.executeNonQuery(stmt,
                    new SqlParameter("@name", tbName.Text),
                    new SqlParameter("@dob", tbBirthdate.Text),
                    new SqlParameter("@gender", rbMale.Checked),
                    new SqlParameter("@address", tbAddress.Text),
                    new SqlParameter("@id", cbID.SelectedItem)
                ))
                {
                    MessageBox.Show("Update success");
                    LoadData();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Update fail: " + ex.Message);
            }
        }
    }
}
