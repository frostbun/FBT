namespace WebApplication1.Models
{
    public class Student
    {
        public string Code { get; set; }
        public string Name { get; set; }
        public int Mark { get; set; }

        public Student(string code, string name, int mark)
        {
            Code = code;
            Name = name;
            Mark = mark;
        }

        public override string ToString()
        {
            return $"Code: {Code}, Name: {Name}, Mark: {Mark}";
        }
    }
}
