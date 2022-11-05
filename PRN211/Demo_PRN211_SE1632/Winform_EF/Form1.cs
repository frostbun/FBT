using Winform_EF.Models;

namespace Winform_EF
{
    public partial class Form1 : Form
    {
        MySaleDBContext context = new();

        public Form1()
        {
            InitializeComponent();
        }

        private void LoadData(string search = "")
        {
            try
            {
                var data = dgProduct.DataSource = context.Products
                    .Select(p => new
                    {
                        Code = p.ProductId,
                        Name = p.ProductName.ToUpper(),
                        Price = p.UnitPrice,
                        Stock = p.UnitsInStock,
                        CategoryName = p.Category.CategoryName,
                        Image = p.Image,
                    })
                    .Where(p => p.Name.Contains(search))
                    .ToList();

                cbbCategory.DataSource = context.Categories.ToList();
                cbbCategory.DisplayMember = "CategoryName";
                cbbCategory.ValueMember = "CategoryId";
                cbbCategory.DataBindings.Clear();
                cbbCategory.DataBindings.Add("Text", data, "CategoryName");

                tbCode.DataBindings.Clear();
                tbCode.DataBindings.Add("Text", data, "Code");

                tbName.DataBindings.Clear();
                tbName.DataBindings.Add("Text", data, "Name");

                tbPrice.DataBindings.Clear();
                tbPrice.DataBindings.Add("Text", data, "Price");

                tbStock.DataBindings.Clear();
                tbStock.DataBindings.Add("Text", data, "Stock");

                tbImage.DataBindings.Clear();
                tbImage.DataBindings.Add("Text", data, "Image");
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error: " + ex.Message);
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            LoadData();
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            try
            {
                context.Products.Add(new()
                {
                    ProductName = tbName.Text,
                    UnitPrice = decimal.Parse(tbPrice.Text),
                    UnitsInStock = int.Parse(tbStock.Text),
                    CategoryId = (int)cbbCategory.SelectedValue,
                    Image = tbImage.Text,
                });
                if (context.SaveChanges() > 0)
                {
                    MessageBox.Show("Success");
                    LoadData();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error: " + ex.Message);
            }
        }

        private void btnUpdate_Click(object sender, EventArgs e)
        {
            try
            {
                Product? p = context.Products.FirstOrDefault(p => p.ProductId.ToString() == tbCode.Text);
                if (p is null)
                {
                    return;
                }
                p.ProductName = tbName.Text;
                p.UnitPrice = decimal.Parse(tbPrice.Text);
                p.UnitsInStock = int.Parse(tbStock.Text);
                p.CategoryId = (int)cbbCategory.SelectedValue;
                p.Image = tbImage.Text;
                context.Products.Update(p);
                if (context.SaveChanges() > 0)
                {
                    MessageBox.Show("Success");
                    LoadData();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error: " + ex.Message);
            }
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            try
            {
                Product? p = context.Products.FirstOrDefault(p => p.ProductId.ToString() == tbCode.Text);
                if (p is null)
                {
                    return;
                }
                context.Products.Remove(p);
                if (context.SaveChanges() > 0)
                {
                    MessageBox.Show("Success");
                    LoadData();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error: " + ex.Message);
            }
        }

        private void btnSearch_Click(object sender, EventArgs e)
        {
            LoadData(tbName.Text);
        }
    }
}