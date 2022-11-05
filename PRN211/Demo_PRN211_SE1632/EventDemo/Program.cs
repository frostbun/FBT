
using System.Security.Authentication.ExtendedProtection;

namespace EventDemo
{
   




    public class Program
    {
        static List<TextBox> lstText = new List<TextBox>();

        static List<CheckBox> lstCheck = new List<CheckBox>();
        static int n = 0;
        static void Main(string[] args)
        {
            Console.WriteLine("Enter number text: ");
            n = Convert.ToInt32(Console.ReadLine());

            Console.WriteLine("Press any key to create text!");
            Console.ReadKey();
            //tao nut
            Button btnCreate = new Button();
            //gan event onclick cho button
            btnCreate.onClick += BtnCreate_onClick;
            btnCreate.click();

            Button btnAdd = new Button();
            btnAdd.onClick += BtnAdd_onClick;
            btnAdd.click();

            Button btnText = new Button();
          

            //mo phong event changecheck
            //moi khi check cua checkbox bi thay doi thi event se xay ra va hien thong bao: name + check/uncheck



            while (true)
            {
                Console.WriteLine("You want to change check? (1,2,3....):");
                int c = Convert.ToInt32(Console.ReadLine());
                if (c > n)
                {
                    break;
                }
                Console.WriteLine("0.check");
                Console.WriteLine("1.uncheck");
                int option = Convert.ToInt32(Console.ReadLine());

                if (option == 0)
                {
                    lstCheck[c - 1].Check = true;
                }
                else
                {
                    lstCheck[c - 1].Check = false;
                }
                
            }

            while (true)
            {
                Console.WriteLine("You want to change Text? (1,2,3....):");
                int c = Convert.ToInt32(Console.ReadLine());
                if (c > n)
                {
                    break;
                }
                Console.WriteLine("Enter your new text");
                
                string option = Console.ReadLine();

                
                    lstCheck[c - 1].Text = option;
               

            }




        }

        private static void BtnCreate_onClick()
        {
            for (int i = 0; i < n; i++)
            {
                TextBox t = new TextBox();
                Console.WriteLine("Enter text" + (i + 1));
                t.Text = Console.ReadLine();
                lstText.Add(t);

            }
            Console.WriteLine("List text");
            for (int i = 0; i < n; i++)
            {
                Console.WriteLine("-Text" + (i + 1) + ":" + lstText[i].Text);
            }
            Console.WriteLine("Press any key to add checkbox");
            Console.ReadKey();



            //tao nut moi gan event xong gan n checkbox vi lop do chua cos nene can tao cos 2 thuoc tinh text vs checked

        }

        private static void BtnAdd_onClick()
        {


            for (int i = 0; i < n; i++)
            {
                CheckBox t = new CheckBox();
                
                t.Text = lstText[i].Text;
                t.CheckChange += T_CheckChange;
                t.CheckChange1 += T_CheckChange11;
                lstCheck.Add(t);

            }

          

            string check = "";

            for (int i = 0; i < n; i++)
            {
                if (lstCheck[i].Check == false)
                {
                    check = "uncheck";
                }
                Console.WriteLine("-Check" + (i + 1) + ":" + lstCheck[i].Text + ";" + check);

            }

        }
        //mo phong sk textchange khi nao, text nao bi thay doi value thi event xay ra va hien message: ten txt: old value=>new value 
        private static void T_CheckChange11(string ntext, string text)
        {
            Console.WriteLine("-CheckBox Text: " + text + "=>  " + ntext);
        }

       
        private static void T_CheckChange(string text, bool check)
        {

            Console.WriteLine("Check "+text+":"+((check)?"Checked":"Uncheck"));
            
        }
    }
}