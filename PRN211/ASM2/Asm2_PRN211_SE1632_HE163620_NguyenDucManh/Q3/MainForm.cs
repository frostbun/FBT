using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Q3
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        private void MainForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            Environment.Exit(0);
        }

        private void rb_CheckedChanged(object sender, EventArgs e)
        {
            if (sender is RadioButton rb)
            {
                if (rb.Checked)
                {
                    pic.Image = Properties.Resources.ResourceManager.GetObject(rb.Text.Replace(" ", "_")) as Image;
                }
            }
        }

        private void btExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btLuna_Click(object sender, EventArgs e)
        {
            this.Hide();
            new LunaForm().Show();
        }
    }
}
