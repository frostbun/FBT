public class Program
{
    static void Main(string[] args)
    {
        while (true)
        {
            Console.WriteLine("Menu: ");
            Console.WriteLine("1. Basic");
            Console.WriteLine("2. Array");
            Console.WriteLine("3. String");
            Console.WriteLine("4. List");
            Console.WriteLine("0. Exit");

            int option = Convert.ToInt32(Console.ReadLine());
            switch (option)
            {
                case 0:
                    return;
                case 1:
                    Basic();
                    break;
                case 2:
                    ArrayDemo();
                    break;
                case 3:
                    StringDemo();
                    break;
                case 4:
                    ListDemo();
                    break;
                default:
                    break;
            }
        }
    }

    private static string FirstName(string name)
    {
        string n = name.Trim().Split(' ')[^1];
        return n[..1].ToUpper() + n[1..];
    }

    private static string LastName(string name)
    {
        string n = name.Trim().Split(' ')[0];
        return n[..1].ToUpper() + n[1..];
    }

    private static string Surname(string name)
    {
        string[] s = name.Split(' ');
        string surname = "";
        for (int i = 1; i < s.Length - 1; ++i)
        {
            s[i] = s[i].Trim();
            if (s[i].Length == 0) continue;
            surname += s[i][..1].ToUpper() + s[i][1..] + " ";
        }
        return surname.Trim();
    }

    private static void ListDemo()
    {
        List<string> list = new List<string>()
        {
            "Le Ngoc Ngoan",
            "Lam Nhu Ngoan",
            "Nguyen Hong Ngoc",
            "Tran Nguyen Tri Thanh",
            "Truong Quoc Tuan",
        };

        Console.WriteLine("Danh sach sv: ");
        foreach (var item in list)
        {
            Console.WriteLine(item);
        }
        Console.WriteLine();

        //1. Hien thi sv ten != "Ngoc"
        //2. Co bn sv co ho <= 3 chu cai
        //3. Hien thi sv ten dem co 1 tu
        //4. Co bn sv ten dai nhat? Hien thi
        //5. Hien thi ds sv theo format: NgoanLN1, NgoanLN2, ...

        // 1
        Console.WriteLine("Sv co ten != Ngoc");
        foreach (var item in list)
        {
            if (FirstName(item) != "Ngoc")
            {
                Console.WriteLine(item);
            }
        }
        Console.WriteLine();

        // 2
        int cnt2 = 0;
        foreach (var item in list)
        {
            if (LastName(item).Length <= 3)
            {
                ++cnt2;
            }
        }
        Console.WriteLine("So sv co ho < 3 chu cai: " + cnt2);
        Console.WriteLine();

        // 3
        Console.WriteLine("Sv ten dem co 1 tu");
        foreach (var item in list)
        {
            if (Surname(item).Split(' ').Length == 1)
            {
                Console.WriteLine(item);
            }
        }
        Console.WriteLine();

        // 4
        int max = int.MinValue;
        int cntMax = 0;
        foreach (var item in list)
        {
            int lenght = FirstName(item).Length;
            if (lenght == max)
            {
                ++cntMax;
            }
            if (lenght > max)
            {
                max = lenght;
                cntMax = 1;
            }
        }
        Console.WriteLine("Co " + cntMax + " sv co ten dai nhat la: ");
        foreach (var item in list)
        {
            int lenght = FirstName(item).Length;
            if (lenght == max)
            {
                Console.WriteLine(item);
            }
        }
        Console.WriteLine();

        // 5
        Console.WriteLine("Code: ");
        List<string> sv = new();
        int[] cnt = new int[list.Count];
        for (int i=0; i<list.Count; ++i)
        {
            string item = list[i];
            string code = FirstName(item) + LastName(item)[0];
            foreach (string s in Surname(item).Split(' '))
            {
                code += s[0];
            }
            if (sv.Contains(code))
            {
                cnt[i] = cnt[sv.LastIndexOf(code)] + 1;
            }
            else
            {
                cnt[i] = 1;
            }
            sv.Add(code);
        }
        for (int i=0; i<sv.Count; ++i)
        {
            if (cnt[sv.LastIndexOf(sv[i])] > 1)
            {
                Console.WriteLine(sv[i] + cnt[i]);
            }
            else
            {
                Console.WriteLine(sv[i]);
            }
        }
        Console.WriteLine();
    }

    private static void StringDemo()
    {
        Console.Write("Enter your name: ");
        string name = Console.ReadLine().Trim().ToLower();

        Console.WriteLine("Lastname: " + LastName(name));
        Console.WriteLine("Firstname: " + FirstName(name));
        Console.WriteLine("Surname: " + Surname(name));
    }

    private static void ArrayDemo()
    {
        int[] a = { 12, 5, 6, 3, 22, 32, 4, 9, 4, 16 };

        PrintArray(a, "Mang hien tai:");

        // 1. Hien thi hop so
        // 2. Co bn scp
        // 3. Tong cac so ko phai scp, ko phai snt
        // 4. Max
        // 5. Co bn so chan Min
        // 6. Sx giam dan
        // 7. Sx so le tang dan

        int cnt_sqr = 0;
        int sum = 0;
        int max = int.MinValue;
        int min = int.MaxValue;
        int cnt_min = 0;
        Console.Write("Hop so: ");
        foreach (var i in a)
        {
            if (!IsPrime(i))
            {
                Console.Write(" " + i);
            }
            if (IsSqr(i))
            {
                ++cnt_sqr;
            }
            if (!IsPrime(i) && !IsSqr(i))
            {
                sum += i;
            }
            if (i > max)
            {
                max = i;
            }
            if (i % 2 == 0)
            {
                if (i == min)
                {
                    ++cnt_min;
                }
                if (i < min)
                {
                    min = i;
                    cnt_min = 1;
                }
            }
        }
        Console.WriteLine();
        Console.WriteLine("Co " + cnt_sqr + " scp");
        Console.WriteLine("Tong cac so ko phai scp, ko phai snt: " + sum);
        Console.WriteLine("Max: " + max);
        Console.WriteLine("So luong so chan min: " + cnt_min);

        int[] b = new int[a.Length];
        Array.Copy(a, b, a.Length);
        Array.Sort(b, (i, j) => j - i);
        PrintArray(b, "Mang sau khi sx giam dan:");

        for (int i = 1; i < a.Length; ++i)
        {
            for (int j = 0; j < i; ++j)
            {
                if (a[i] % 2 == 1 && a[j] % 2 == 1 && a[i] < a[j])
                {
                    (a[j], a[i]) = (a[i], a[j]);
                }
            }
        }
        PrintArray(a, "Mang sau khi so le tang dan:");

        Console.WriteLine();
    }

    private static void PrintArray(int[] a, string v)
    {
        Console.Write(v);
        for (int i = 0; i < a.Length; ++i)
        {
            Console.Write(" " + a[i]);
        }
        Console.WriteLine();
    }

    private static bool IsSqr(int i)
    {
        int sqrt = (int)Math.Sqrt(i);
        return sqrt * sqrt == i;
    }

    private static void Basic()
    {
        //nhap 1 so nguyen n tu bp, coi n la tong so giay, hien thi hh/mm/ss
        int n = Enter("Nhap so nguyen N: ");
        Console.WriteLine("hh/mm/ss: " + n / 3600 + "/" + n / 60 % 60 + "/" + n % 60);
        //N co bn chu so
        Console.WriteLine("N co " + ((int)Math.Log10(n) + 1) + " chu so");
        //tinh tong cac chu so chan trong N
        int sum0 = 0;
        for (int i = n; i > 0; i /= 10)
        {
            if (i % 2 == 0)
            {
                sum0 += i % 10;
            }
        }
        Console.WriteLine("Tong cac chu so chan trong N: " + sum0);
        //hien thi cac uoc nguyen to cua N
        Console.Write("Cac uoc nguyen to cua N:");
        for (int i = 2; i <= n; i++)
        {
            if (IsPrime(i))
            {
                Console.Write(" " + i);
            }
        }
    }

    private static bool IsPrime(int n)
    {
        for (int i = 2; i < n; ++i)
        {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static int Enter(string v)
    {
        while (true)
        {
            try
            {
                Console.Write(v);
                return Convert.ToInt32(Console.ReadLine());
            }
            catch
            {
                Console.WriteLine("Nhap lai");
            }
        }
    }
}
