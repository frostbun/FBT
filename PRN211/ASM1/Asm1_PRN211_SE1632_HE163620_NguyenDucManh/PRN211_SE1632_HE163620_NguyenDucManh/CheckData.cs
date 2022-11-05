using System;

namespace PRN211_SE1632_HE163620_NguyenDucManh
{
    public class CheckData
    {
        public static int GetInt(string prompt)
        {
            while (true)
            {
                try
                {
                    return Convert.ToInt32(GetString(prompt));
                }
                catch
                {
                    Console.WriteLine("Invalid!");
                }
            }
        }

        public static string GetString(string prompt)
        {
            while (true)
            {
                Console.WriteLine(prompt);
                string? input = Console.ReadLine();
                if (input != null)
                {
                    return input;
                }
                Console.WriteLine("Invalid!");
            }
        }
    }
}