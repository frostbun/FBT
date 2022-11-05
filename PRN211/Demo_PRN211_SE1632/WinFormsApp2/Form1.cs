using System.Data.SqlClient;

namespace WinFormsApp2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        DataProvider d = new();

        private void btnLogin_Click(object sender, EventArgs e)
        {
            //try
            //{
            //    string query = $"SELECT * FROM Users WHERE account='{tbAccount.Text}' AND password='{tbPassword.Text}'";
            //    var result = d.executeQuery(query);
            //    if (result.Rows.Count > 0)
            //    {
            //        MessageBox.Show("Login success!");
            //        new CustomerForm(tbAccount.Text).Show();
            //        this.Hide();
            //    }
            //    else
            //    {
            //        MessageBox.Show("Login fail!");
            //    }
            //}
            //catch (Exception ex)
            //{
            //    MessageBox.Show("Login fail: " + ex.Message);
            //}
            try
            {
                string query = "SELECT * FROM Users WHERE account=@account AND password=@password";
                using var r = d.executeQuery2(query, new SqlParameter[] { new("@account", tbAccount.Text), new("@password", tbPassword.Text) });
                if (r.Read())
                {
                    MessageBox.Show("Login success!");
                    new CustomerForm(tbAccount.Text).Show();
                    this.Hide();
                }
                else
                {
                    MessageBox.Show("Login fail!");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Login fail: " + ex.Message);
            }
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            Close();
        }
    }
}