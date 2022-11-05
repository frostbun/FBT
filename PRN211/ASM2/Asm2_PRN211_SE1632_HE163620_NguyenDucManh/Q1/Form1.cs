namespace Q1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnCalc_Click(object sender, EventArgs e)
        {
            if (tbName.Text == "")
            {
                MessageBox.Show("Please enter your name");
                return;
            }
            int total = 0;
            if (cbCleaning.Checked)
            {
                total += 100000;
            }
            if (cbWhitening.Checked)
            {
                total += 1200000;
            }
            if (cbXRay.Checked)
            {
                total += 200000;
            }
            total += (int)nmFilling.Value * 80000;
            tbTotal.Text = total.ToString();
        }
    }
}