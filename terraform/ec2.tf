resource "aws_instance" "master" {
 ami           = "ami-0f5ee92e2d63afc18"
 instance_type = var.instance_type
 security_groups = [aws_security_group.jenkins_sg.name]

 tags = { Name = "Jenkins-Master" }
}

resource "aws_instance" "agent" {
 ami           = "ami-0f5ee92e2d63afc18"
 instance_type = var.instance_type
 security_groups = [aws_security_group.jenkins_sg.name]

 tags = { Name = "Jenkins-Agent" }
}
