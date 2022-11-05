namespace WFEvent
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        int n;
        private List<TextBox> textBoxes = new();

        private void btnSubmit_Click(object sender, EventArgs e)
        {
            n = (int)numText.Value;
            for (int i = 0; i < n; ++i)
            {
                var lb = new Label();
                var tb = new TextBox();

                lb.Location = new Point(100, 10 + i * 30);
                lb.Size = new Size(100, 30);
                lb.Text = $"Text {i + 1}: ";

                tb.Location = new Point(200, 10 + i * 30);
                tb.Size = new Size(100, 30);
                tb.Enter += (_, _) =>
                {
                    tb.BackColor = Color.Pink;
                };
                tb.Leave += (_, _) =>
                {
                    tb.BackColor = Color.White;
                };

                this.Controls.Add(lb);
                this.Controls.Add(tb);
                textBoxes.Add(tb);
            }
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < n; ++i)
            {
                var cb = new CheckBox();
                var btn = new Button();

                cb.Location = new Point(350, 10 + i * 30);
                cb.Size = new Size(100, 30);
                cb.Text = textBoxes[i].Text;
                cb.CheckedChanged += (_, _) =>
                {
                    MessageBox.Show($"You {(cb.Checked ? "checked" : "unchecked")} {cb.Text}");
                };

                btn.Location = new Point(450, 10 + i * 30);
                btn.Size = new Size(100, 30);
                btn.Text = "Change "+i;
                btn.Click += (_, _) =>
                {
                    cb.Text = textBoxes[int.Parse(btn.Text[7..])].Text;
                };

                this.Controls.Add(cb);
                this.Controls.Add(btn);
            }
        }
    }
}