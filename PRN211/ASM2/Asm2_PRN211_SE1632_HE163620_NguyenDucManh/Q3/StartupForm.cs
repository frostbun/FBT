namespace Q3
{
    public partial class StartupForm : Form
    {
        public StartupForm()
        {
            InitializeComponent();
        }

        private async void StartupForm_Load(object sender, EventArgs e)
        {
            for (int i = 1; i <= 100; ++i)
            {
                await Task.Delay(10);
                pb.Value = i;
            }
            this.Hide();
            new MainForm().Show();
        }
    }
}