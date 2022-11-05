namespace EventDemo
{
    public class CheckBox
    {
      

        private string text;

        public string Text
        {
            get { return text; }
            set {
                if (text != value)
                {
                    if (CheckChange1 != null)
                    {
                        CheckChange1(value,text);
                    }

                }
                text = value; }
        }

        private bool _check;

        public bool Check
        {
            get { return _check; }
            set
            {
                if (_check != value)
                {
                    if (CheckChange != null)
                    {
                        CheckChange(Text, value);
                    }



                }
                _check = value;
            }
        }


        //taao su kien checkchange
        public delegate void handle(string text, bool check);
        public event handle CheckChange;

        public delegate void handle1(string text, string ntext);
        public event handle1 CheckChange1;

    }
}