resource "aws_security_group" "loja_sg" {
  name        = "loja_sg"
  description = "Loja Security Group"
  vpc_id      = aws_vpc.loja_vpc.id
}

resource "aws_security_group_rule" "loja_sg_public_out" {
  from_port         = 0
  protocol          = "-1"
  security_group_id = aws_security_group.loja_sg.id
  to_port           = 0
  type              = "egress"
  cidr_blocks       = ["0.0.0.0/0"]
}

resource "aws_security_group_rule" "loja_sg_https_in" {
  from_port         = 443
  protocol          = "tcp"
  security_group_id = aws_security_group.loja_sg.id
  to_port           = 443
  type              = "ingress"
  cidr_blocks       = ["0.0.0.0/0"]
}

resource "aws_security_group_rule" "loja_sg_ssh_in" {
  from_port         = 22
  protocol          = "tcp"
  security_group_id = aws_security_group.loja_sg.id
  to_port           = 22
  type              = "ingress"
  cidr_blocks       = ["0.0.0.0/0"]
}

resource "aws_key_pair" "loja_key" {
  key_name   = "loja_key"
  public_key = file("~/.ssh/loja_key.pub")
}

