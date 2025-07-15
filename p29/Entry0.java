public class CustomerRepository 
{
    private readonly DbContext _context;

    public CustomerRepository(DbContext context)
    {
        _context = context;
    }

    public Customer GetById(int id)
    {
        return _context.Set<Customer>().Find(id);
    }

    public IEnumerable<Customer> GetAll()
    {
        return _context.Set<Customer>().ToList();
    }

    public void Add(Customer entity)
    {
        _context.Set<Customer>().Add(entity);
        _context.SaveChanges();
    }

    public void Update(Customer entity)
    {
        _context.Entry(entity).State = EntityState.Modified;
        _context.SaveChanges();
    }

    public void Delete(Customer entity)
    {
        _context.Set<Customer>().Remove(entity);
        _context.SaveChanges();
    }
}

public class OrderRepository 
{
    private readonly DbContext _context;

    public OrderRepository(DbContext context)
    {
        _context = context;
    }

    public Order GetById(int id)
    {
        return _context.Set<Order>().Find(id);
    }

    public IEnumerable<Order> GetAll()
    {
        return _context.Set<Order>().ToList();
    }

    public void Add(Order entity)
    {
        _context.Set<Order>().Add(entity);
        _context.SaveChanges();
    }

    public void Update(Order entity)
    {
        _context.Entry(entity).State = EntityState.Modified;
        _context.SaveChanges();
    }

    public void Delete(Order entity)
    {
        _context.Set<Order>().Remove(entity);
        _context.SaveChanges();
    }
}

public class ProductRepository 
{
    private readonly DbContext _context;

    public ProductRepository(DbContext context)
    {
        _context = context;
    }

    public Product GetById(int id)
    {
        return _context.Set<Product>().Find(id);
    }

    public IEnumerable<Product> GetAll()
    {
        return _context.Set<Product>().ToList();
    }

    public void Add(Product entity)
    {
        _context.Set<Product>().Add(entity);
        _context.SaveChanges();
    }

    public void Update(Product entity)
    {
        _context.Entry(entity).State = EntityState.Modified;
        _context.SaveChanges();
    }

    public void Delete(Product entity)
    {
        _context.Set<Product>().Remove(entity);
        _context.SaveChanges();
    }
}
