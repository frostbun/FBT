using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PRN211_SE1632_HE163620_NguyenDucManh
{
    public class Q3
    {
        static string FirstName(string name)
        {
            string n = name.Trim().ToLower().Split(' ')[^1];
            return n[..1].ToUpper() + n[1..];
        }

        static string LastName(string name)
        {
            string n = name.Trim().ToLower().Split(' ')[0];
            return n[..1].ToUpper() + n[1..];
        }

        static string Surname(string name)
        {
            string[] s = name.Trim().ToLower().Split(' ');
            string surname = "";
            for (int i = 1; i < s.Length - 1; ++i)
            {
                s[i] = s[i].Trim();
                if (s[i].Length == 0) continue;
                surname += s[i][..1].ToUpper() + s[i][1..] + " ";
            }
            return surname.Trim();
        }

        public static void Run()
        {
            List<string> list = new()
            {
                "Le Ngoc Ngoan",
                "Lam Nhu Ngoan",
                "Nguyen Hong Ngoc",
                "Tran Nguyen Tri Thanh",
                "Truong Quoc Tuan",
            };

            Console.WriteLine(list.Where(name => FirstName(name) == "Yen").Count() + " students that firstname is 'Yen'");
            Console.WriteLine(list.Where(name => Surname(name) == "Van").Count() + " students have 'Van' padding");
            Console.WriteLine(list.Where(name => LastName(name).StartsWith("N")).Count() + " students that lastname start with 'N'");
            Console.WriteLine();
        }
    }
}
