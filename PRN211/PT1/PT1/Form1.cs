using Q5;
using System.Data.SqlClient;

namespace PT1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        DataProvider dp = new();

        private void LoadData(string search = "")
        {
            try
            {
                var data = dp.ExecuteQuery(@"
                    SELECT
                        ProductID,
                        ProductName,
                        CompanyName,
                        UnitsInStock
                    FROM Products
                    JOIN Suppliers
                    ON Products.SupplierID = Suppliers.SupplierID
                    WHERE ProductName LIKE '%" + search + "%'"
                );
                dgProduct.DataSource = data;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }
        
        private void btnSearch_Click(object sender, EventArgs e)
        {
            LoadData(txtName.Text);
        }
    }
}