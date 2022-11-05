namespace Q3.Models
{
    public class Contract
    {
        public string Code { get; set; } = null!;
        public string CustomerName { get; set; } = null!;
        public string EmployeeName { get; set; } = null!;
        public string Type { get; set; } = null!;
        public DateTime SignedDate { get; set; }
    }
}
