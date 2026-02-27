resource "aws_eip" "master_eip" {
  instance = aws_instance.master.id
}
