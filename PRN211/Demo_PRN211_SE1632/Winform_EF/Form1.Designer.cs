namespace Winform_EF
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label5 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.btnDelete = new System.Windows.Forms.Button();
            this.btnUpdate = new System.Windows.Forms.Button();
            this.tbImage = new System.Windows.Forms.TextBox();
            this.tbName = new System.Windows.Forms.TextBox();
            this.dgProduct = new System.Windows.Forms.DataGridView();
            this.btnAdd = new System.Windows.Forms.Button();
            this.tbPrice = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.cbbCategory = new System.Windows.Forms.ComboBox();
            this.tbStock = new System.Windows.Forms.TextBox();
            this.label6 = new System.Windows.Forms.Label();
            this.tbCode = new System.Windows.Forms.TextBox();
            this.btnSearch = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.dgProduct)).BeginInit();
            this.SuspendLayout();
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label5.Location = new System.Drawing.Point(62, 176);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(76, 30);
            this.label5.TabIndex = 33;
            this.label5.Text = "Image:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label3.Location = new System.Drawing.Point(62, 110);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(101, 30);
            this.label3.TabIndex = 31;
            this.label3.Text = "UnitPrice:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label2.Location = new System.Drawing.Point(395, 48);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(146, 30);
            this.label2.TabIndex = 30;
            this.label2.Text = "ProductName:";
            // 
            // btnDelete
            // 
            this.btnDelete.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.btnDelete.Location = new System.Drawing.Point(409, 244);
            this.btnDelete.Name = "btnDelete";
            this.btnDelete.Size = new System.Drawing.Size(107, 47);
            this.btnDelete.TabIndex = 27;
            this.btnDelete.Text = "Delete";
            this.btnDelete.UseVisualStyleBackColor = true;
            this.btnDelete.Click += new System.EventHandler(this.btnDelete_Click);
            // 
            // btnUpdate
            // 
            this.btnUpdate.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.btnUpdate.Location = new System.Drawing.Point(271, 244);
            this.btnUpdate.Name = "btnUpdate";
            this.btnUpdate.Size = new System.Drawing.Size(107, 47);
            this.btnUpdate.TabIndex = 26;
            this.btnUpdate.Text = "Update";
            this.btnUpdate.UseVisualStyleBackColor = true;
            this.btnUpdate.Click += new System.EventHandler(this.btnUpdate_Click);
            // 
            // tbImage
            // 
            this.tbImage.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.tbImage.Location = new System.Drawing.Point(179, 173);
            this.tbImage.Name = "tbImage";
            this.tbImage.Size = new System.Drawing.Size(187, 35);
            this.tbImage.TabIndex = 25;
            // 
            // tbName
            // 
            this.tbName.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.tbName.Location = new System.Drawing.Point(547, 45);
            this.tbName.Name = "tbName";
            this.tbName.Size = new System.Drawing.Size(187, 35);
            this.tbName.TabIndex = 24;
            // 
            // dgProduct
            // 
            this.dgProduct.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgProduct.Location = new System.Drawing.Point(38, 318);
            this.dgProduct.Name = "dgProduct";
            this.dgProduct.RowTemplate.Height = 25;
            this.dgProduct.Size = new System.Drawing.Size(722, 201);
            this.dgProduct.TabIndex = 22;
            // 
            // btnAdd
            // 
            this.btnAdd.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.btnAdd.Location = new System.Drawing.Point(129, 244);
            this.btnAdd.Name = "btnAdd";
            this.btnAdd.Size = new System.Drawing.Size(107, 47);
            this.btnAdd.TabIndex = 21;
            this.btnAdd.Text = "Add";
            this.btnAdd.UseVisualStyleBackColor = true;
            this.btnAdd.Click += new System.EventHandler(this.btnAdd_Click);
            // 
            // tbPrice
            // 
            this.tbPrice.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.tbPrice.Location = new System.Drawing.Point(179, 107);
            this.tbPrice.Name = "tbPrice";
            this.tbPrice.Size = new System.Drawing.Size(187, 35);
            this.tbPrice.TabIndex = 18;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label1.Location = new System.Drawing.Point(62, 48);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(111, 30);
            this.label1.TabIndex = 17;
            this.label1.Text = "ProductID:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label4.Location = new System.Drawing.Point(395, 176);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(101, 30);
            this.label4.TabIndex = 37;
            this.label4.Text = "Category:";
            // 
            // cbbCategory
            // 
            this.cbbCategory.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.cbbCategory.FormattingEnabled = true;
            this.cbbCategory.Location = new System.Drawing.Point(547, 173);
            this.cbbCategory.Name = "cbbCategory";
            this.cbbCategory.Size = new System.Drawing.Size(187, 38);
            this.cbbCategory.TabIndex = 36;
            // 
            // tbStock
            // 
            this.tbStock.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.tbStock.Location = new System.Drawing.Point(547, 107);
            this.tbStock.Name = "tbStock";
            this.tbStock.Size = new System.Drawing.Size(187, 35);
            this.tbStock.TabIndex = 35;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label6.Location = new System.Drawing.Point(395, 110);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(132, 30);
            this.label6.TabIndex = 34;
            this.label6.Text = "UnitsInStock:";
            // 
            // tbCode
            // 
            this.tbCode.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.tbCode.Location = new System.Drawing.Point(179, 45);
            this.tbCode.Name = "tbCode";
            this.tbCode.ReadOnly = true;
            this.tbCode.Size = new System.Drawing.Size(187, 35);
            this.tbCode.TabIndex = 38;
            // 
            // btnSearch
            // 
            this.btnSearch.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.btnSearch.Location = new System.Drawing.Point(547, 244);
            this.btnSearch.Name = "btnSearch";
            this.btnSearch.Size = new System.Drawing.Size(107, 47);
            this.btnSearch.TabIndex = 39;
            this.btnSearch.Text = "Search";
            this.btnSearch.UseVisualStyleBackColor = true;
            this.btnSearch.Click += new System.EventHandler(this.btnSearch_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 548);
            this.Controls.Add(this.btnSearch);
            this.Controls.Add(this.tbCode);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.cbbCategory);
            this.Controls.Add(this.tbStock);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.btnDelete);
            this.Controls.Add(this.btnUpdate);
            this.Controls.Add(this.tbImage);
            this.Controls.Add(this.tbName);
            this.Controls.Add(this.dgProduct);
            this.Controls.Add(this.btnAdd);
            this.Controls.Add(this.tbPrice);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dgProduct)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private Label label5;
        private Label label3;
        private Label label2;
        private Button btnDelete;
        private Button btnUpdate;
        private TextBox tbImage;
        private TextBox tbName;
        private DataGridView dgProduct;
        private Button btnAdd;
        private TextBox tbPrice;
        private Label label1;
        private Label label4;
        private ComboBox cbbCategory;
        private TextBox tbStock;
        private Label label6;
        private TextBox tbCode;
        private Button btnSearch;
    }
}