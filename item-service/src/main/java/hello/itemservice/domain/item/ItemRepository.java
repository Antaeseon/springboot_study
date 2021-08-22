package hello.itemservice.domain.item;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository { // command shift t 누르면 테스트 생성

    //ConcurrentHashmap AtomicLong 사용 필요
    private static final Map<Long, Item> store = new HashMap<>(); //실제는 hashmap 사용하면 안된다. => 동시에 여러 쓰레드 접근 가능
    private static long sequence = 0L; // static

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        // 실제로는 클래스를 하나 만들어서 dto 처리를 하는 것이 더 알맞다. 이렇게 하면 설계상 명확해지게 된다.
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }


    public void clearStore(){
        store.clear();
    }

}
