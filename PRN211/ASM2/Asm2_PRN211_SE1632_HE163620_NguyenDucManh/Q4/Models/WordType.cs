using System;
using System.Collections.Generic;

namespace Q4.Models
{
    public partial class WordType
    {
        public WordType()
        {
            Dictionaries = new HashSet<Dictionary>();
        }

        public int Id { get; set; }
        public string TypeName { get; set; } = null!;

        public virtual ICollection<Dictionary> Dictionaries { get; set; }
    }
}
