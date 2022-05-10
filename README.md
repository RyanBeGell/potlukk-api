# Potlukk: Team 2
## Entities & Attributes
1. Potluck
   * Potluck_ID (serial, primary key)
   * Date/Time (UNIX Epoch)
   * Creator (foreign key)
   * Is_Private (Boolean)
   * URL
2. Item
   * Item_ID (serial, primary key)
   * Description
   * Status
   * Supplier 
   * Potluck_ID (foreign key)
3. User
   * Username (primary key)
   * First Name
   * Last Name
   * Password

## User Stories & Routes

1. Create
   * Create Potluck (POST /potlucks)
     - Date, Time, 
   * Registered user can add items (POST /items)
   * Guest user can add item (POST /items)
   * Guest can create account (POST /users)
2. Read
   * Guest can view potlucks (GET /potlucks)
   * Get URL/Link to potluck (GET /potlucks/{potluck_ID})
   * Get all items for a potluck (GET to /potlucks/{potluck_ID}/items)
3. Update
   * registered User can update potluck date/time (PATCH /potlucks/{potluck_ID})
   * User can update Status of Item to fulfilled (PATCH /item/{item_ID}/bringing)
4. Delete
   * Registered user can remove items (DELETE to url/items/{item_ID})
   * Registered user can delete potluck (DELETE to url/potlucks/{potluck_id})