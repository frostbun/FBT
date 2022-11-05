using System;
using System.Collections.Generic;

namespace Asm3_PRN211_SE1632_HE163620_NguyenDucManh.Models
{
    public partial class Customer
    {
        public string CustomerCode { get; set; } = null!;
        public string CustomerName { get; set; } = null!;
        public bool Gender { get; set; }
        public string? Address { get; set; }
        public DateTime? Dob { get; set; }
    }
}
