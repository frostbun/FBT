using System.Collections.Generic;
using System;
using System.IO;

namespace OOP
{
    public class Manager : IManager
    {
        public List<Student> List { get; } = new();
        public bool ReSave { get; private set;  } = false;

        public void ShowList()
        {
            foreach (var student in List)
            {
                Console.WriteLine(student);
            }
        }

        public void InputList()
        {
            ReSave = true;
            Console.WriteLine("Enter code: ");
            string code = Console.ReadLine();
            Console.WriteLine("Enter name: ");
            string name = Console.ReadLine();
            Console.WriteLine("Enter mark: ");
            int mark = Convert.ToInt32(Console.ReadLine());
            List.Add(new(code, name, mark));
        }

        public void Update(string code)
        {
            ReSave = true;
            foreach (var student in List)
            {
                if (student.Code == code)
                {
                    Console.WriteLine("Enter name: ");
                    student.Name = Console.ReadLine();
                    Console.WriteLine("Enter mark: ");
                    student.Mark = Convert.ToInt32(Console.ReadLine());
                }
            }
        }

        public void Delete(string code)
        {
            ReSave = true;
            for (int i = 0; i < List.Count; ++i)
            {
                if (List[i].Code == code)
                {
                    List.RemoveAt(i);
                }
            }
        }

        public void SaveFile()
        {
            ReSave = false;
            string filename = @"..\..\..\data.txt";
            using (StreamWriter sw = new(filename))
            {
                List.ForEach(sw.WriteLine);
            }
        }

        public void LoadFile()
        {
            string filename = @"..\..\..\data.txt";
            using (StreamReader sr = new(filename))
            {
                string? line;
                while ((line = sr.ReadLine()) != null)
                {
                    string[] s = line.Split('\t');
                    bool add = true;
                    foreach (var student in List)
                    {
                        if (student.Code == s[0])
                        {
                            add = false;
                            break;
                        }
                    }
                    if (!add) continue;
                    List.Add(new(s[0], s[1], Convert.ToInt32(s[2])));
                }
            }
        }

        public void Exit()
        {
            if (!ReSave) return;
            Console.Write("Do you want to save? (y/n): ");
            string option = Console.ReadLine();
            while (option != "y" && option != "n")
            {
                option = Console.ReadLine();
            }
            if (option == "y") SaveFile();
        }
    }
}
