resource "aws_vpc" "loja_vpc" {
  cidr_block           = "10.0.0.0/16"
  enable_dns_hostnames = true
  enable_dns_support   = true

  tags = {
    Name = "loja_vpc"
  }
}

resource "aws_subnet" "loja_subnet" {
  vpc_id                  = aws_vpc.loja_vpc.id
  cidr_block              = "10.0.1.0/24"
  availability_zone       = "us-east-1a"
  map_public_ip_on_launch = true

  tags = {
    Name = "loja_subnet_public"
  }
}

resource "aws_internet_gateway" "loja_igw" {
  vpc_id = aws_vpc.loja_vpc.id

  tags = {
    Name = "loja_igw"
  }
}

resource "aws_route_table" "loja_rt" {
  vpc_id = aws_vpc.loja_vpc.id

  tags = {
    Name = "loja_rt"
  }
}

resource "aws_route" "loja_route" {
  route_table_id         = aws_route_table.loja_rt.id
  destination_cidr_block = "0.0.0.0/0"
  gateway_id             = aws_internet_gateway.loja_igw.id
}

resource "aws_route_table_association" "loja_rtb_association" {
  route_table_id = aws_route_table.loja_rt.id
  subnet_id      = aws_subnet.loja_subnet.id
}

resource "aws_instance" "loja_ec2_instance" {
  instance_type          = "t2.micro"
  key_name               = "loja_key"
  vpc_security_group_ids = [aws_security_group.loja_sg.id]
  subnet_id              = aws_subnet.loja_subnet.id
  ami                    = data.aws_ami.loja_ami.id

  user_data = file("userdata.tpl")

  root_block_device {
    volume_size = 8
  }

  tags = {
    Name = "loja_ec2_instance"
  }

}