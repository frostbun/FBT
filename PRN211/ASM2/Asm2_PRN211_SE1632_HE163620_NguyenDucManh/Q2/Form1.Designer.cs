namespace Q2
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
            this.bt1 = new System.Windows.Forms.Button();
            this.tbCode = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.lbLog = new System.Windows.Forms.ListBox();
            this.bt2 = new System.Windows.Forms.Button();
            this.bt8 = new System.Windows.Forms.Button();
            this.bt7 = new System.Windows.Forms.Button();
            this.bt9 = new System.Windows.Forms.Button();
            this.btEnter = new System.Windows.Forms.Button();
            this.bt6 = new System.Windows.Forms.Button();
            this.bt5 = new System.Windows.Forms.Button();
            this.bt4 = new System.Windows.Forms.Button();
            this.bt0 = new System.Windows.Forms.Button();
            this.btClear = new System.Windows.Forms.Button();
            this.bt3 = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // bt1
            // 
            this.bt1.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.bt1.Location = new System.Drawing.Point(139, 90);
            this.bt1.Name = "bt1";
            this.bt1.Size = new System.Drawing.Size(50, 50);
            this.bt1.TabIndex = 18;
            this.bt1.Text = "1";
            this.bt1.UseVisualStyleBackColor = true;
            this.bt1.Click += new System.EventHandler(this.bt_Click);
            // 
            // tbCode
            // 
            this.tbCode.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.tbCode.Location = new System.Drawing.Point(225, 31);
            this.tbCode.Name = "tbCode";
            this.tbCode.PasswordChar = '*';
            this.tbCode.ReadOnly = true;
            this.tbCode.Size = new System.Drawing.Size(202, 35);
            this.tbCode.TabIndex = 17;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label2.Location = new System.Drawing.Point(77, 34);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(142, 30);
            this.label2.TabIndex = 16;
            this.label2.Text = "Security code:";
            // 
            // lbLog
            // 
            this.lbLog.FormattingEnabled = true;
            this.lbLog.ItemHeight = 15;
            this.lbLog.Location = new System.Drawing.Point(34, 306);
            this.lbLog.Name = "lbLog";
            this.lbLog.Size = new System.Drawing.Size(420, 229);
            this.lbLog.TabIndex = 19;
            // 
            // bt2
            // 
            this.bt2.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.bt2.Location = new System.Drawing.Point(195, 90);
            this.bt2.Name = "bt2";
            this.bt2.Size = new System.Drawing.Size(50, 50);
            this.bt2.TabIndex = 20;
            this.bt2.Text = "2";
            this.bt2.UseVisualStyleBackColor = true;
            this.bt2.Click += new System.EventHandler(this.bt_Click);
            // 
            // bt8
            // 
            this.bt8.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.bt8.Location = new System.Drawing.Point(195, 202);
            this.bt8.Name = "bt8";
            this.bt8.Size = new System.Drawing.Size(50, 50);
            this.bt8.TabIndex = 21;
            this.bt8.Text = "8";
            this.bt8.UseVisualStyleBackColor = true;
            this.bt8.Click += new System.EventHandler(this.bt_Click);
            // 
            // bt7
            // 
            this.bt7.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.bt7.Location = new System.Drawing.Point(139, 202);
            this.bt7.Name = "bt7";
            this.bt7.Size = new System.Drawing.Size(50, 50);
            this.bt7.TabIndex = 22;
            this.bt7.Text = "7";
            this.bt7.UseVisualStyleBackColor = true;
            this.bt7.Click += new System.EventHandler(this.bt_Click);
            // 
            // bt9
            // 
            this.bt9.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.bt9.Location = new System.Drawing.Point(251, 202);
            this.bt9.Name = "bt9";
            this.bt9.Size = new System.Drawing.Size(50, 50);
            this.bt9.TabIndex = 23;
            this.bt9.Text = "9";
            this.bt9.UseVisualStyleBackColor = true;
            this.bt9.Click += new System.EventHandler(this.bt_Click);
            // 
            // btEnter
            // 
            this.btEnter.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            this.btEnter.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.btEnter.ForeColor = System.Drawing.Color.Red;
            this.btEnter.Location = new System.Drawing.Point(307, 146);
            this.btEnter.Name = "btEnter";
            this.btEnter.Size = new System.Drawing.Size(50, 50);
            this.btEnter.TabIndex = 24;
            this.btEnter.Text = "#";
            this.btEnter.UseVisualStyleBackColor = false;
            this.btEnter.Click += new System.EventHandler(this.btEnter_Click);
            // 
            // bt6
            // 
            this.bt6.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.bt6.Location = new System.Drawing.Point(251, 146);
            this.bt6.Name = "bt6";
            this.bt6.Size = new System.Drawing.Size(50, 50);
            this.bt6.TabIndex = 25;
            this.bt6.Text = "6";
            this.bt6.UseVisualStyleBackColor = true;
            this.bt6.Click += new System.EventHandler(this.bt_Click);
            // 
            // bt5
            // 
            this.bt5.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.bt5.Location = new System.Drawing.Point(195, 146);
            this.bt5.Name = "bt5";
            this.bt5.Size = new System.Drawing.Size(50, 50);
            this.bt5.TabIndex = 26;
            this.bt5.Text = "5";
            this.bt5.UseVisualStyleBackColor = true;
            this.bt5.Click += new System.EventHandler(this.bt_Click);
            // 
            // bt4
            // 
            this.bt4.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.bt4.Location = new System.Drawing.Point(139, 146);
            this.bt4.Name = "bt4";
            this.bt4.Size = new System.Drawing.Size(50, 50);
            this.bt4.TabIndex = 27;
            this.bt4.Text = "4";
            this.bt4.UseVisualStyleBackColor = true;
            this.bt4.Click += new System.EventHandler(this.bt_Click);
            // 
            // bt0
            // 
            this.bt0.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.bt0.Location = new System.Drawing.Point(307, 202);
            this.bt0.Name = "bt0";
            this.bt0.Size = new System.Drawing.Size(50, 50);
            this.bt0.TabIndex = 28;
            this.bt0.Text = "0";
            this.bt0.UseVisualStyleBackColor = true;
            this.bt0.Click += new System.EventHandler(this.bt_Click);
            // 
            // btClear
            // 
            this.btClear.BackColor = System.Drawing.Color.Yellow;
            this.btClear.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.btClear.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(192)))), ((int)(((byte)(0)))));
            this.btClear.Location = new System.Drawing.Point(307, 90);
            this.btClear.Name = "btClear";
            this.btClear.Size = new System.Drawing.Size(50, 50);
            this.btClear.TabIndex = 29;
            this.btClear.Text = "C";
            this.btClear.UseVisualStyleBackColor = false;
            this.btClear.Click += new System.EventHandler(this.btClear_Click);
            // 
            // bt3
            // 
            this.bt3.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.bt3.Location = new System.Drawing.Point(251, 90);
            this.bt3.Name = "bt3";
            this.bt3.Size = new System.Drawing.Size(50, 50);
            this.bt3.TabIndex = 30;
            this.bt3.Text = "3";
            this.bt3.UseVisualStyleBackColor = true;
            this.bt3.Click += new System.EventHandler(this.bt_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Segoe UI", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label1.Location = new System.Drawing.Point(171, 265);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(142, 30);
            this.label1.TabIndex = 31;
            this.label1.Text = "Security code:";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(484, 561);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.bt3);
            this.Controls.Add(this.btClear);
            this.Controls.Add(this.bt0);
            this.Controls.Add(this.bt4);
            this.Controls.Add(this.bt5);
            this.Controls.Add(this.bt6);
            this.Controls.Add(this.btEnter);
            this.Controls.Add(this.bt9);
            this.Controls.Add(this.bt7);
            this.Controls.Add(this.bt8);
            this.Controls.Add(this.bt2);
            this.Controls.Add(this.lbLog);
            this.Controls.Add(this.bt1);
            this.Controls.Add(this.tbCode);
            this.Controls.Add(this.label2);
            this.Name = "Form1";
            this.Text = "Security Panel";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private Button bt1;
        private TextBox tbCode;
        private Label label2;
        private ListBox lbLog;
        private Button bt2;
        private Button bt8;
        private Button bt7;
        private Button bt9;
        private Button btEnter;
        private Button bt6;
        private Button bt5;
        private Button bt4;
        private Button bt0;
        private Button btClear;
        private Button bt3;
        private Label label1;
    }
}