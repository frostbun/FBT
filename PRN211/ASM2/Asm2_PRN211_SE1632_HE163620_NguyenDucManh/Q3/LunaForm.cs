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
    public partial class LunaForm : Form
    {
        public LunaForm()
        {
            InitializeComponent();
        }

        private void btExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        List<string> Can = new() { "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ", "Canh", "Tân", "Nhâm", "Quý" };
        List<string> Chi = new() { "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi", "Thân", "Dậu", "Tuất", "Hợi" };

        private void btCalc_Click(object sender, EventArgs e)
        {
            int year = (int)nmYear.Value;
            int can = (year + 6) % 10;
            int chi = (year + 8) % 12;
            tbResult.Text = Can[can] + " " + Chi[chi];
        }

        private void LunaForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            Environment.Exit(0);
        }
    }
}
