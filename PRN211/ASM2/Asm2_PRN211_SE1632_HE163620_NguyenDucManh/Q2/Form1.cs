namespace Q2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void bt_Click(object sender, EventArgs e)
        {
            if (sender is Button bt)
            {
                tbCode.Text += bt.Text;
            }
        }

        private void btClear_Click(object sender, EventArgs e)
        {
            tbCode.Text = "";
        }

        Dictionary<string, List<string>> passwords = new()
        {
            ["Technicians"] = new() { "1645", "1689" },
            ["Custodians"] = new() { "8345" },
            ["Scientist"] = new() { "9998", "1006", "1007", "1008" }
        };

        private void btEnter_Click(object sender, EventArgs e)
        {
            foreach (var (group, pwds) in passwords)
            {
                if (pwds.Contains(tbCode.Text))
                {
                    lbLog.Items.Add($"{DateTime.Now}\t{group}");
                    return;
                }
            }
            lbLog.Items.Add($"{DateTime.Now}\tRestricted Access!");
        }
    }
}