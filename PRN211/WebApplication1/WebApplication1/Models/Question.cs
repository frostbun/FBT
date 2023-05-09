namespace WebApplication1.Models
{
    public class Question
    {
        public int Id { get; set; }
        public string Title { get; set; } = null!;
        public string A { get; set; } = null!;
        public string B { get; set; } = null!;
        public string C { get; set; } = null!;
        public string D { get; set; } = null!;
        public string Answer { get; set; } = null!;
    }
}
