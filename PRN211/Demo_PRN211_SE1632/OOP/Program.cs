using System;

namespace OOP
{
    public class Program
    {
        static void Main(string[] args)
        {
            IManager m = new Manager();

            while (true)
            {
                Console.WriteLine("1. Input student to list");
                Console.WriteLine("2. Show list students");
                Console.WriteLine("3. Update informations by code");
                Console.WriteLine("4. Remove student by code");
                Console.WriteLine("5. Save to file txt");
                Console.WriteLine("6. Load from file");
                Console.WriteLine("7. Report");
                Console.WriteLine("0. Exit");

                int option = Convert.ToInt32(Console.ReadLine());
                switch (option)
                {
                    case 1:
                        m.InputList();
                        break;
                    case 2:
                        m.ShowList();
                        break;
                    case 3:
                        {
                            Console.WriteLine("Enter code: ");
                            string code = Console.ReadLine();
                            m.Update(code);
                            break;
                        }
                    case 4:
                        {
                            Console.WriteLine("Enter code: ");
                            string code = Console.ReadLine();
                            m.Delete(code);
                            break;
                        }
                    case 5:
                        m.SaveFile();
                        break;
                    case 6:
                        m.LoadFile();
                        break;
                    case 7:
                        break;
                    case 0:
                        m.Exit();
                        return;
                }
            }
        }
    }
}
