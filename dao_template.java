import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class {capitalized_name}Dao {{
    @PersistenceContext
    EntityManager entityManager;

    public {capitalized_name} create ({capitalized_name} {small_letter_name}) {{
        entityManager.persist({small_letter_name});
        return {small_letter_name};
    }}

    public {capitalized_name} read(Integer id) {{
        {capitalized_name} {small_letter_name} = entityManager.find({capitalized_name}.class, id);
        return {small_letter_name};
    }}

    public {capitalized_name} update ({capitalized_name} {small_letter_name}, Integer id) {{
        {capitalized_name} {small_letter_name}ToChange = entityManager.find({capitalized_name}.class, id);
{update}
        return {small_letter_name}ToChange;
    }}

    public Boolean delete({capitalized_name} {small_letter_name}, Integer id) {{
        {capitalized_name} {small_letter_name}ToDelete = entityManager.find({capitalized_name}.class, id);
        entityManager.remove({small_letter_name}ToDelete);
        return Boolean.TRUE;
    }}

    public List<{capitalized_name}> findAll() {{
        return (List<{capitalized_name}>) entityManager.createQuery("SELECT {first_letter} FROM {capitalized_name} {first_letter}").getResultList();
    }}
}}