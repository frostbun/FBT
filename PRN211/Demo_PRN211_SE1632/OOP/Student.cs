namespace OOP
{
	public class Student
	{
		public string Code { get; set; }

		private string _name;

		public string Name
		{
			get { return _name.ToUpper(); }
			set { _name = value; }
		}

		private int _mark;

		public int Mark
		{
			get { return _mark; }
			set
			{
				_mark = value;
				if (Name.Trim().ToLower().StartsWith("nguyen"))
				{
					_mark += 1;
				}
			}
		}

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
			return Code + "\t" + Name + "\t" + Mark;
		}
	}
}
