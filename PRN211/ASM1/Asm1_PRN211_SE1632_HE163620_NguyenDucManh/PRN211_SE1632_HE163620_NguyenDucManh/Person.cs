namespace PRN211_SE1632_HE163620_NguyenDucManh
{
    public abstract class Person
    {
        public string Code { get; set; } = "";
        public string Name { get; set; } = "";
        public string Address { get; set; } = ""; 
        public string Position { get; set; } = "";
        public int Salary { get; set; }

        public override string ToString()
        {
            return $"Code: {Code}, Name: {Name}, Address: {Address}, Position: {Position}, Salary: {Salary}";
        }
    }

    public class Player : Person
    {
        public int ShirtNumber { get; set; }

        public override string ToString()
        {
            return base.ToString() + $", ShirtNumber: {ShirtNumber}";
        }
    }

    public class Coach : Person
    {
        public int YearsOfExperience { get; set; }

        public override string ToString()
        {
            return base.ToString() + $", YearsOfExperience: {YearsOfExperience}";
        }
    }
}
