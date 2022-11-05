namespace Q4
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
            this.dgDict = new System.Windows.Forms.DataGridView();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.tbWord = new System.Windows.Forms.TextBox();
            this.btUpdate = new System.Windows.Forms.Button();
            this.tbMeaning = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.cbbType = new System.Windows.Forms.ComboBox();
            this.btInsert = new System.Windows.Forms.Button();
            this.btDelete = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.dgDict)).BeginInit();
            this.SuspendLayout();
            // 
            // dgDict
            // 
            this.dgDict.AllowUserToAddRows = false;
            this.dgDict.AllowUserToDeleteRows = false;
            this.dgDict.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgDict.Location = new System.Drawing.Point(41, 257);
            this.dgDict.Name = "dgDict";
            this.dgDict.ReadOnly = true;
            this.dgDict.RowTemplate.Height = 25;
            this.dgDict.Size = new System.Drawing.Size(717, 241);
            this.dgDict.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Segoe UI", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point);
            this.label1.Location = new System.Drawing.Point(316, 39);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(152, 37);
            this.label1.TabIndex = 1;
            this.label1.Text = "Dictionary";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label2.Location = new System.Drawing.Point(79, 116);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(68, 30);
            this.label2.TabIndex = 2;
            this.label2.Text = "Word:";
            // 
            // tbWord
            // 
            this.tbWord.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.tbWord.Location = new System.Drawing.Point(153, 113);
            this.tbWord.Name = "tbWord";
            this.tbWord.Size = new System.Drawing.Size(194, 35);
            this.tbWord.TabIndex = 3;
            // 
            // btUpdate
            // 
            this.btUpdate.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.btUpdate.Location = new System.Drawing.Point(526, 186);
            this.btUpdate.Name = "btUpdate";
            this.btUpdate.Size = new System.Drawing.Size(107, 42);
            this.btUpdate.TabIndex = 4;
            this.btUpdate.Text = "Update";
            this.btUpdate.UseVisualStyleBackColor = true;
            this.btUpdate.Click += new System.EventHandler(this.btUpdate_Click);
            // 
            // tbMeaning
            // 
            this.tbMeaning.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.tbMeaning.Location = new System.Drawing.Point(507, 113);
            this.tbMeaning.Name = "tbMeaning";
            this.tbMeaning.Size = new System.Drawing.Size(225, 35);
            this.tbMeaning.TabIndex = 6;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label3.Location = new System.Drawing.Point(401, 116);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(100, 30);
            this.label3.TabIndex = 5;
            this.label3.Text = "Meaning:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label4.Location = new System.Drawing.Point(80, 189);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(61, 30);
            this.label4.TabIndex = 7;
            this.label4.Text = "Type:";
            // 
            // cbbType
            // 
            this.cbbType.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.cbbType.FormattingEnabled = true;
            this.cbbType.Location = new System.Drawing.Point(153, 186);
            this.cbbType.Name = "cbbType";
            this.cbbType.Size = new System.Drawing.Size(194, 38);
            this.cbbType.TabIndex = 8;
            // 
            // btInsert
            // 
            this.btInsert.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.btInsert.Location = new System.Drawing.Point(413, 186);
            this.btInsert.Name = "btInsert";
            this.btInsert.Size = new System.Drawing.Size(107, 42);
            this.btInsert.TabIndex = 9;
            this.btInsert.Text = "Insert";
            this.btInsert.UseVisualStyleBackColor = true;
            this.btInsert.Click += new System.EventHandler(this.btInsert_Click);
            // 
            // btDelete
            // 
            this.btDelete.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.btDelete.Location = new System.Drawing.Point(639, 186);
            this.btDelete.Name = "btDelete";
            this.btDelete.Size = new System.Drawing.Size(107, 42);
            this.btDelete.TabIndex = 10;
            this.btDelete.Text = "Delete";
            this.btDelete.UseVisualStyleBackColor = true;
            this.btDelete.Click += new System.EventHandler(this.btDelete_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 533);
            this.Controls.Add(this.btDelete);
            this.Controls.Add(this.btInsert);
            this.Controls.Add(this.cbbType);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.tbMeaning);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.btUpdate);
            this.Controls.Add(this.tbWord);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.dgDict);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dgDict)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private Button btDelete;
        private Button btInsert;
        private ComboBox cbbType;
        private Label label4;
        private TextBox tbMeaning;
        private Label label3;
        private Button btUpdate;
        private TextBox tbWord;
        private Label label2;
        private Label label1;
        private DataGridView dgDict;
    }
}