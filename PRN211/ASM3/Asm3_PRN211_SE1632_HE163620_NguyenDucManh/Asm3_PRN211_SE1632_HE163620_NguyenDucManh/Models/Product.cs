using System;
using System.Collections.Generic;

namespace Asm3_PRN211_SE1632_HE163620_NguyenDucManh.Models
{
    public partial class Product
    {
        public string ProductCode { get; set; } = null!;
        public string ProductName { get; set; } = null!;
        public string Unit { get; set; } = null!;
        public float? Price { get; set; }
        public string? Image { get; set; }
    }
}
