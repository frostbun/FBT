using Q1.Models;

namespace Q1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            using (var ctx = new PE_PRN_Fall22B1Context())
            {
                var directors = ctx.Directors.ToList();
                var stars = ctx.Stars.ToList();

                cbxDirector.DataSource = directors;
                cbxDirector.DisplayMember = "FullName";
                cbxDirector.ValueMember = "Id";

                lbxStar.DataSource = stars;
                lbxStar.DisplayMember = "FullName";
                lbxStar.ValueMember = "Id";
            }
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            using (var ctx = new PE_PRN_Fall22B1Context())
            {
                var movie = new Movie()
                {
                    Title = txtTitle.Text,
                    ReleaseDate = dtReleaseDate.Value,
                    Description = txtDescription.Text,
                    Language = txtLanguage.Text,
                    DirectorId = (int)cbxDirector.SelectedValue,
                };
                foreach (var starId in lbxStar.SelectedItems.Cast<Star>().Select(s => s.Id).ToList())
                {
                    var star = ctx.Stars.FirstOrDefault(s => s.Id == starId);
                    if (star is not null)
                    {
                        movie.Stars.Add(star);
                    }
                }
                ctx.Movies.Add(movie);
                if (ctx.SaveChanges() == 0)
                {
                    MessageBox.Show("Add new movie failed");
                }
                else
                {
                    MessageBox.Show("Add new movie successfully");
                }
            }
        }
    }
}