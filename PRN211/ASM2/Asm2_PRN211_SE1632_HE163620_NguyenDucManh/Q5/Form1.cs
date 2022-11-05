using System.Data.SqlClient;

namespace Q5
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        DataProvider dp = new();

        private void LoadData()
        {
            try
            {
                var data = dp.ExecuteQuery(@"
                    SELECT
                        ID = WordID,
                        Word = Word,
                        Meaning = Meaning,
                        Type = TypeName,
                        EditDate = EditDate
                    FROM Dictionary
                    JOIN WordType
                    ON Dictionary.ID = WordType.ID
                ");

                dgDict.DataSource = data;

                cbbType.DataSource = dp.ExecuteQuery("SELECT * FROM WordType");
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
                if (dp.ExecuteNonQuery(@"
                    INSERT INTO Dictionary(Word, Meaning, EditDate, ID)
                    VALUES (@word, @meaning, @editDate, @id)",
                    new SqlParameter("@word", tbWord.Text),
                    new SqlParameter("@meaning", tbMeaning.Text),
                    new SqlParameter("@editDate", DateTime.Today),
                    new SqlParameter("@id", cbbType.SelectedValue)
                ))
                {
                    LoadData();
                }
                else
                {
                    MessageBox.Show("Insert failed");
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
                if (dp.ExecuteNonQuery(@"
                    UPDATE Dictionary
                    SET
                        Word = @word,
                        Meaning = @meaning,
                        EditDate = @editDate,
                        ID = @id
                    WHERE WordID = @wordID",
                    new SqlParameter("@wordID", dgDict.SelectedCells[0].OwningRow.Cells[0].Value),
                    new SqlParameter("@word", tbWord.Text),
                    new SqlParameter("@meaning", tbMeaning.Text),
                    new SqlParameter("@editDate", DateTime.Today),
                    new SqlParameter("@id", cbbType.SelectedValue)
                ))
                {
                    LoadData();
                }
                else
                {
                    MessageBox.Show("Update failed");
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
                if (dp.ExecuteNonQuery(@"
                    DELETE FROM Dictionary
                    WHERE WordID = @wordID",
                    new SqlParameter("@wordID", dgDict.SelectedCells[0].OwningRow.Cells[0].Value)
                ))
                {
                    LoadData();
                }
                else
                {
                    MessageBox.Show("Delete failed");
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