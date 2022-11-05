namespace EventDemo
{
    public class Button
    { 
        
        public string Caption { get; set; }
        //tao event
        //onclick


        public delegate void handle();
        public event handle onClick;
        //khi nao thi event dc kich hoat
        //khi nhan vao button nao do
        // mo phong thao tac nhan button
        public void click()
        {
            //check xem nut do da dc gan event chua neu roi thi thuc hien event
            if (onClick!= null)
            {
                onClick();
            }



        }

     
    }
}