resource "aws_instance" "master" {
  ami                    = "ami-0f5ee92e2d63afc18"
  instance_type          = "t3.micro"
  subnet_id              = aws_subnet.public_subnet.id
  vpc_security_group_ids = [aws_security_group.jenkins_sg.id]
  iam_instance_profile   = aws_iam_instance_profile.ec2_profile.name
  key_name               = "rohit-ec2-key"

  tags = { Name = "Jenkins-Master" }
}

resource "aws_instance" "agent" {
  ami                    = "ami-0f5ee92e2d63afc18"
  instance_type          = "t3.micro"
  subnet_id              = aws_subnet.public_subnet.id
  vpc_security_group_ids = [aws_security_group.jenkins_sg.id]
  iam_instance_profile   = aws_iam_instance_profile.ec2_profile.name
  key_name               = "rohit-ec2-key"

  tags = { Name = "Jenkins-Agent" }
}
