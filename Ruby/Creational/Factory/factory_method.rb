# factory method on ruby

class Product
  def initialize(name)
    @name = name
  end

  def use
    puts "use #{@name}"
  end
end

class Factory
  def create(owner)
    p = create_product(owner)
    register_product(p)
    p
  end

  def create_product(owner)
    raise NotImplementedError.new("You must implement #{self.class}##{__method__}")
  end

  def register_product(product)
    raise NotImplementedError.new("You must implement #{self.class}##{__method__}")
  end
end

class IDCardFactory < Factory
  def initialize
    @owners = []
  end

  def create_product(owner)
    IDCard.new(owner)
  end

  def register_product(product)
    @owners << product.owner
  end

  def get_owners
    @owners
  end
end

class IDCard < Product
  attr_reader :owner

  def initialize(owner)
    @owner = owner
    puts "create #{@owner}'s card"
  end
end

factory = IDCardFactory.new
puts ''
card1 = factory.create("Alice")
card2 = factory.create("Bob")
card3 = factory.create("Charlie")
puts ''
card1.use
card2.use
card3.use
puts ''
puts factory.get_owners
