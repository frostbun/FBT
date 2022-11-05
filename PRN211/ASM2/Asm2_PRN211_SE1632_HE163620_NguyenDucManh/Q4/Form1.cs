using Q4.Models;

namespace Q4
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        MyDB2Context context = new();

        private void LoadData()
        {
            try
            {
                var data = context.Dictionaries
                    .Select(d => new
                    {
                        ID = d.WordId,
                        Word = d.Word,
                        Meaning = d.Meaning,
                        Type = d.IdNavigation.TypeName,
                        EditDate = d.EditDate,
                    })
                    .ToList();

                dgDict.DataSource = data;

                cbbType.DataSource = context.WordTypes.ToList();
                cbbType.DisplayMember = "TypeName";
                cbbType.ValueMember = "ID";
                cbbType.DataBindings.Clear();
                cbbType.DataBindings.Add("Text", data, "Type");

                tbWord.DataBindings.Clear();
                tbWord.DataBindings.Add("Text", data, "Word");

                tbMeaning.DataBindings.Clear();
                tbMeaning.DataBindings.Add("Text", data, "Meaning");
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void btInsert_Click(object sender, EventArgs e)
        {
            try
            {
                var word = new Dictionary
                {
                    Word = tbWord.Text,
                    Meaning = tbMeaning.Text,
                    EditDate = DateTime.Today,
                    Id = (int)cbbType.SelectedValue,
                };
                context.Dictionaries.Add(word);
                if (context.SaveChanges() == 0)
                {
                    MessageBox.Show("Insert failed");
                }
                else
                {
                    LoadData();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void btUpdate_Click(object sender, EventArgs e)
        {
            try
            {
                if (context.Dictionaries
                    .FirstOrDefault(d => d.WordId.ToString() == dgDict.SelectedCells[0].OwningRow.Cells[0].Value.ToString())
                    is not Dictionary word
                )
                {
                    MessageBox.Show("Please select a row to update!");
                    return;
                }
                word.Word = tbWord.Text;
                word.Meaning = tbMeaning.Text;
                word.EditDate = DateTime.Today;
                word.Id = (int)cbbType.SelectedValue;
                context.Dictionaries.Update(word);
                if (context.SaveChanges() == 0)
                {
                    MessageBox.Show("Update failed");
                }
                else
                {
                    LoadData();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void btDelete_Click(object sender, EventArgs e)
        {
            try
            {
                if (context.Dictionaries
                    .FirstOrDefault(d => d.WordId.ToString() == dgDict.SelectedCells[0].OwningRow.Cells[0].Value.ToString())
                    is not Dictionary word
                )
                {
                    MessageBox.Show("Please select a row to delete!");
                    return;
                }
                context.Dictionaries.Remove(word);
                if (context.SaveChanges() == 0)
                {
                    MessageBox.Show("Delete failed");
                }
                else
                {
                    LoadData();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            LoadData();
        }
    }
}