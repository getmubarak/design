public interface ICustomerRepository
{
    Customer GetById(int id);
    IEnumerable<Customer> GetAll();
    void Add(Customer entity);
    void Update(Customer entity);
    void Delete(Customer entity);
}

public interface IOrderRepository
{
    Order GetById(int id);
    IEnumerable<Order> GetAll();
    void Add(Order entity);
    void Update(Order entity);
    void Delete(Order entity);
}

// Similar for ProductRepository...

public class CustomerRepository : ICustomerRepository
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

// Similarly for OrderRepository, ProductRepository...
