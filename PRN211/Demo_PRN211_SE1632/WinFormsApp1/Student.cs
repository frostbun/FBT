namespace WinFormsApp1
{
    internal class Student
    {
        public string Code { get; set; } = "";
        public string Name { get; set; } = "";
        public string Subject { get; set; } = "";
        public int Mark { get; set; }

        public override string ToString()
        {
            return $"{Code}\t{Name}\t{Subject}\t{Mark}";
        }

        public override bool Equals(object? obj)
        {
            if (obj is Student s)
            {
                return s.Code == Code;
            }
            return false;
        }

        public override int GetHashCode()
        {
            return Code.GetHashCode();
        }
    }
}
