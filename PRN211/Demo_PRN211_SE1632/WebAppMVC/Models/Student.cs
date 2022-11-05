﻿using System.ComponentModel.DataAnnotations;

namespace WebAppMVC.Models
{
    public class Student
    {
        [Required(AllowEmptyStrings =false,ErrorMessage ="no String is empty")]
        public string Code { get; set; }
        [Required(AllowEmptyStrings = false, ErrorMessage = "no String is empty")]
        public string Name { get; set; }
        [Range(0,10)]
        public int Mark { get; set; }

        public Student()
        {
        }

        public Student(string code, string name, int mark)
        {
            Code = code;
            Name = name;
            Mark = mark;
        }

        public override string? ToString()
        {
            return "Code: "+Code+ "\nName: " + Name + "\nMark: " + Mark;
        }
    }
}
