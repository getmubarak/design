public interface IRepository<T> where T : class
{
    T GetById(int id);
    IEnumerable<T> GetAll();
    void Add(T entity);
    void Update(T entity);
    void Delete(T entity);
}


public class Repository<T> : IRepository<T> where T : class
{
    private readonly DbContext _context;
    private readonly DbSet<T> _dbSet;

    public Repository(DbContext context)
    {
        _context = context;
        _dbSet = context.Set<T>();
    }

    public T GetById(int id)
    {
        return _dbSet.Find(id);
    }

    public IEnumerable<T> GetAll()
    {
        return _dbSet.ToList();
    }

    public void Add(T entity)
    {
        _dbSet.Add(entity);
        _context.SaveChanges();
    }

    public void Update(T entity)
    {
        _dbSet.Attach(entity);
        _context.Entry(entity).State = EntityState.Modified;
        _context.SaveChanges();
    }

    public void Delete(T entity)
    {
        if (_context.Entry(entity).State == EntityState.Detached)
        {
            _dbSet.Attach(entity);
        }
        _dbSet.Remove(entity);
        _context.SaveChanges();
    }
}

public class Customer { /* Customer properties */ }
public class Order { /* Order properties */ }
public class Product { /* Product properties */ }

public class CustomerRepository : Repository<Customer>
{
    public CustomerRepository(DbContext context) : base(context) { }
}

public class OrderRepository : Repository<Order>
{
    public OrderRepository(DbContext context) : base(context) { }
}

public class ProductRepository : Repository<Product>
{
    public ProductRepository(DbContext context) : base(context) { }
}


var context = new DbContext(); // Assume DbContext is already set up
var customerRepository = new CustomerRepository(context);

var newCustomer = new Customer { /* Set properties */ };
customerRepository.Add(newCustomer);

var allCustomers = customerRepository.GetAll();
var customer = customerRepository.GetById(1);

customerRepository.Delete(customer);
