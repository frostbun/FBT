using System;
using System.Collections.Generic;

namespace FinalProject.Models
{
    public partial class Notification
    {
        public int Id { get; set; }
        public int Days { get; set; }
        public int Hours { get; set; }
        public int Minutes { get; set; }
        public int EventId { get; set; }

        public virtual Event Event { get; set; } = null!;
    }
}
