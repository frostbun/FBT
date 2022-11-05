using Microsoft.Extensions.Configuration;
using System.Data;
using System.Data.SqlClient;

namespace Q5
{
    public class DataProvider
    {
        SqlConnection conn;

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
            return config.GetConnectionString("MyDB2");
        }

        public DataTable ExecuteQuery(string query, params SqlParameter[] parameters)
        {
            var dt = new DataTable();
            var cmd = new SqlCommand(query, conn);
            cmd.Parameters.AddRange(parameters);
            var adapter = new SqlDataAdapter(cmd);
            adapter.Fill(dt);
            return dt;
        }

        public bool ExecuteNonQuery(string query, params SqlParameter[] parameters)
        {
            var cmd = new SqlCommand(query, conn);
            cmd.Parameters.AddRange(parameters);
            return cmd.ExecuteNonQuery() > 0;
        }
    }
}
