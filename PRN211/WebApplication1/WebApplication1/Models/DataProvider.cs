using System.Data;
using System.Data.SqlClient;

namespace WebApplication1.Models
{
    public class DataProvider
    {
        private readonly SqlConnection conn;

        public DataProvider()
        {
            conn = new(GetConnectionString());
            if (conn.State == ConnectionState.Open)
            {
                conn.Close();
            }
            conn.Open();
        }

        private static string GetConnectionString()
        {
            var config = new ConfigurationBuilder()
                .SetBasePath(Directory.GetCurrentDirectory())
                .AddJsonFile("appsettings.json", true, true)
                .Build();
            return config.GetConnectionString("MyDB");
        }

        public IDataReader ExecuteQuery(string query, params SqlParameter[] parameters)
        {
            var cmd = new SqlCommand(query, conn);
            cmd.Parameters.AddRange(parameters);
            return cmd.ExecuteReader();
        }

        public bool ExecuteNonQuery(string query, params SqlParameter[] parameters)
        {
            var cmd = new SqlCommand(query, conn);
            cmd.Parameters.AddRange(parameters);
            return cmd.ExecuteNonQuery() > 0;
        }
    }
}
