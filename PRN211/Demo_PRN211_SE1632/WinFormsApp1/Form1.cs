namespace WinFormsApp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnReset_Click(object sender, EventArgs e)
        {
            tbCode.Text = "";
            tbName.Text = "";
            cbSubject.Text = "";
            nmMark.Value = 0;
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show(this, "Do you want to exit?", "Alert!", MessageBoxButtons.YesNo) == DialogResult.Yes)
            {
                Close();
            }
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            Student s = new()
            {
                Code = tbCode.Text,
                Name = tbName.Text,
                Subject = cbSubject.SelectedItem.ToString(),
                Mark = (int)nmMark.Value,
            };
            if (lbStudent.Items.Contains(s))
            {
                MessageBox.Show(this, "Student already exists!", "Alert!", MessageBoxButtons.OK);
                return;
            }
            lbStudent.Items.Add(s);
        }

        private void lbStudent_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (lbStudent.SelectedItem is Student s)
            {
                tbCode.Text = s.Code;
                tbName.Text = s.Name;
                cbSubject.Text = s.Subject;
                nmMark.Value = s.Mark;
            }
            else
            {
                tbName.Text = "";
                cbSubject.Text = "";
                nmMark.Value = 0;
            }
        }

        private void btnRemove_Click(object sender, EventArgs e)
        {
            if (lbStudent.SelectedIndex != -1)
            {
                lbStudent.Items.RemoveAt(lbStudent.SelectedIndex);
            }
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            using (StreamWriter sw = new("student.txt"))
            {
                foreach (Student s in lbStudent.Items)
                {
                    sw.WriteLine(s);
                }
            }
        }

        private void btnLoad_Click(object sender, EventArgs e)
        {
            using (StreamReader sr = new("student.txt"))
            {
                string? line;
                while ((line = sr.ReadLine()) != null)
                {
                    string[] tokens = line.Split('\t');
                    Student s = new()
                    {
                        Code = tokens[0],
                        Name = tokens[1],
                        Subject = tokens[2],
                        Mark = int.Parse(tokens[3]),
                    };
                    if (!lbStudent.Items.Contains(s))
                    {
                        lbStudent.Items.Add(s);
                    }
                }
            }
        }

        private void tb_Enter(object sender, EventArgs e)
        {
            if (sender is TextBox tb)
            {
                tb.BackColor = Color.Pink;
            }
        }

        private void tb_Leave(object sender, EventArgs e)
        {
            if (sender is TextBox tb)
            {
                tb.BackColor = Color.White;
            }
        }

        private void tbCode_TextChanged(object sender, EventArgs e)
        {
            lbStudent.SelectedItem = lbStudent.Items.Cast<Student>().FirstOrDefault(s => s.Code == tbCode.Text);
        }
    }
}