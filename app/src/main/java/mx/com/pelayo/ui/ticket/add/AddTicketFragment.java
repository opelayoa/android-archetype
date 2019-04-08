package mx.com.pelayo.ui.ticket.add;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.common.collect.Iterables;

import org.w3c.dom.Text;

import javax.inject.Inject;

import mx.com.pelayo.App;
import mx.com.pelayo.R;
import mx.com.pelayo.database.entities.Usuario;
import mx.com.pelayo.database.entities.custom.ItemAutocomplete;
import mx.com.pelayo.database.entities.custom.UserInformation;
import mx.com.pelayo.ui.ticket.add.adapter.CustomArrayAdapter;
import mx.com.pelayo.viewmodel.AddTicketViewModel;

public class AddTicketFragment extends Fragment {

    private static final String TYPE_PARAM = "type_id";
    private static final String SYMPTOM_PARAM = "symptom";
    private static final String DIAGNOSTIC_PARAM = "symptom";

    @Inject
    AddTicketViewModel addTicketViewModel;

    private AutoCompleteTextView applicant;
    private AutoCompleteTextView region;
    private AutoCompleteTextView expert;
    private AutoCompleteTextView district;
    private AutoCompleteTextView store;
    private AutoCompleteTextView user;
    private AutoCompleteTextView diagnostic;
    private AutoCompleteTextView place;
    private TextView comment;
    private CheckBox approved;
    private RadioGroup options;
    private RadioButton optionStore;
    private RadioButton optionOthers;

    private AutoCompleteTextView department;

    private LinearLayout layoutOther;
    private LinearLayout layoutStore;

    private int typeId;
    private int symptomId;
    private int diagnosticId;

    private Integer regionId;
    private Integer applicantId;
    private Integer expertId;
    private Integer districtId;
    private Integer storeId;

    private Integer departmentId;
    private Integer userId;

    private UserInformation usuarioInfo;

    public AddTicketFragment() {
        // Required empty public constructor
    }

    public static AddTicketFragment newInstance(Integer typeId, Integer symptomId, Integer diagnosticId)

    {
        AddTicketFragment fragment = new AddTicketFragment();
        Bundle args = new Bundle();
        args.putInt(TYPE_PARAM, typeId);
        args.putInt(SYMPTOM_PARAM, symptomId);
        args.putInt(DIAGNOSTIC_PARAM, diagnosticId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getActivity().getApplicationContext()).getApplicationComponent().inject(this);
        if (getArguments() != null) {
            typeId = getArguments().getInt(TYPE_PARAM);
            symptomId = getArguments().getInt(SYMPTOM_PARAM);
            diagnosticId = getArguments().getInt(DIAGNOSTIC_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_ticket, container, false);
        this.usuarioInfo = addTicketViewModel.getUsuarioInfo();
        configRegions(view);
        configApplicants(view);
        configExpert(view);
        configDistrict(view);
        configStores(view);
        configDepartments(view);
        configUsers(view);
        configDiagnostic(view);
        configPlace(view);
        configApproved(view);
        configComment(view);
        configRegionStates(view);
        return view;
    }

    private void configRegions(View view) {
        region = view.findViewById(R.id.region);
        CustomArrayAdapter<ItemAutocomplete> regionAdapter = new CustomArrayAdapter(getContext(), android.R.layout.simple_dropdown_item_1line);
        addTicketViewModel.getRegions().observe(this, regions -> {
            regionAdapter.clear();
            regionAdapter.addAll(regions);
            regionAdapter.notifyDataSetChanged();
            ItemAutocomplete item = Iterables.tryFind(regions, input -> input.getId().equals(usuarioInfo.getRegionId())).orNull();
            if (item != null) {
                regionId = item.getId();
                region.setText(item.getLabel());
            } else {
                regionId = regions.get(0).getId();
                region.setText(regions.get(0).getLabel());
            }
            region.setOnFocusChangeListener((v, hasFocus) -> {
                if (hasFocus) {
                    region.setText("");
                } else {
                    ItemAutocomplete itemAutocomplete = Iterables.tryFind(regions, input -> input.getId() == regionId).orNull();
                    if (itemAutocomplete != null) {
                        region.setText(itemAutocomplete.getLabel());
                    } else {
                        region.setText(getString(R.string.emptyRegions));
                    }
                }
            });
            addTicketViewModel.setFilterRegion(regionId);
        });
        region.setAdapter(regionAdapter);
        region.setOnItemClickListener((parent, view1, position, id) -> {
            ItemAutocomplete data = (ItemAutocomplete) parent.getItemAtPosition(position);
            regionId = data.getId();
            addTicketViewModel.setFilterRegion(regionId);
            addTicketViewModel.setExpertParams(new AddTicketViewModel.ExpertParams(departmentId, regionId));
            hideKeyboard();
        });
        region.setOnClickListener(v -> region.setText(""));
    }

    private void configApplicants(View view) {
        applicant = view.findViewById(R.id.applicant);
        CustomArrayAdapter<Usuario> applicantAdapter = new CustomArrayAdapter(getContext(), android.R.layout.simple_dropdown_item_1line);
        addTicketViewModel.getUsers().observe(this, applicants -> {
            applicantAdapter.clear();
            applicantAdapter.addAll(applicants);
            System.out.println(usuarioInfo.getId());
            applicantAdapter.notifyDataSetChanged();
            Usuario item = Iterables.tryFind(applicants, input -> input.getId() == usuarioInfo.getId()).orNull();
            if (item != null) {
                applicant.setText(item.toString());
                applicantId = item.getId();
                departmentId = item.getDepartamentoId();
            } else {
                applicant.setText(applicants.get(0).toString());
                applicantId = applicants.get(0).getId();
                departmentId = applicants.get(0).getDepartamentoId();
            }
            applicant.setOnFocusChangeListener((v, hasFocus) -> {
                if (hasFocus) {
                    applicant.setText("");
                } else {
                    Usuario user = Iterables.tryFind(applicants, input -> input.getId() == applicantId).orNull();
                    if (user != null) {
                        applicant.setText(user.toString());
                    } else {
                        applicant.setText(getString(R.string.emptyRegions));
                    }
                }
            });
            addTicketViewModel.setExpertParams(new AddTicketViewModel.ExpertParams(departmentId, regionId));

        });
        applicant.setAdapter(applicantAdapter);
        applicant.setOnItemClickListener((parent, view1, position, id) -> {
            Usuario data = (Usuario) parent.getItemAtPosition(position);
            this.applicantId = data.getId();
            addTicketViewModel.setExpertParams(new AddTicketViewModel.ExpertParams(data.getDepartamentoId(), regionId));
            hideKeyboard();
        });
        applicant.setOnClickListener(v -> applicant.setText(""));
    }

    private void configExpert(View view) {
        expert = view.findViewById(R.id.expert);
        CustomArrayAdapter<ItemAutocomplete> expertAdapter = new CustomArrayAdapter(getContext(), android.R.layout.simple_dropdown_item_1line);
        addTicketViewModel.getExperts().observe(this, experts -> {
            expertAdapter.clear();
            expertAdapter.addAll(experts);
            expertAdapter.notifyDataSetChanged();
            expert.setText(experts.get(0).getLabel());
            expertId = experts.get(0).getId();
            expert.setOnFocusChangeListener((v, hasFocus) -> {
                if (hasFocus) {
                    expert.setText("");
                } else {
                    ItemAutocomplete item = Iterables.tryFind(experts, input -> input.getId() == expertId).orNull();
                    if (item != null) {
                        expert.setText(item.toString());
                    } else {
                        expert.setText(getString(R.string.emptyExperts));
                    }
                }
            });
        });
        expert.setAdapter(expertAdapter);
        expert.setOnItemClickListener((parent, view1, position, id) -> {
            ItemAutocomplete data = (ItemAutocomplete) parent.getItemAtPosition(position);
            expertId = data.getId();
            hideKeyboard();
        });
        expert.setOnClickListener(v -> expert.setText(""));
    }

    private void configDistrict(View view) {
        district = view.findViewById(R.id.district);
        CustomArrayAdapter<ItemAutocomplete> districtAdapter = new CustomArrayAdapter(getContext(), android.R.layout.simple_dropdown_item_1line);
        addTicketViewModel.getDistricts().observe(this, districts -> {
            districtAdapter.clear();
            districtAdapter.addAll(districts);
            districtAdapter.notifyDataSetChanged();
            district.setText(districts.get(0).getLabel());
            districtId = districts.get(0).getId();
            this.addTicketViewModel.setFilterDistrict(districtId);
            district.setOnFocusChangeListener((v, hasFocus) -> {
                if (hasFocus) {
                    district.setText("");
                } else {
                    ItemAutocomplete item = Iterables.tryFind(districts, input -> input.getId() == districtId).orNull();
                    district.setText(item.getLabel());
                }
            });
        });
        district.setAdapter(districtAdapter);
        district.setOnItemClickListener((parent, view1, position, id) -> {
            ItemAutocomplete data = (ItemAutocomplete) parent.getItemAtPosition(position);
            districtId = data.getId();
            this.addTicketViewModel.setFilterDistrict(districtId);
            hideKeyboard();
        });
        district.setOnClickListener(v -> {
            district.setText("");
        });

    }

    private void configStores(View view) {
        store = view.findViewById(R.id.store);
        CustomArrayAdapter<ItemAutocomplete> storeAdapter = new CustomArrayAdapter(getContext(), android.R.layout.simple_dropdown_item_1line);
        addTicketViewModel.getStores().observe(this, stores -> {
            storeAdapter.clear();
            storeAdapter.addAll(stores);
            storeAdapter.notifyDataSetChanged();
            if (stores != null && stores.size() > 0) {
                store.setText(stores.get(0).getLabel());
                storeId = stores.get(0).getId();
                enableView(store);
            } else {
                store.setText(getString(R.string.stores_empty));
                disableView(store);
                storeId = null;
            }
            store.setOnFocusChangeListener((v, hasFocus) -> {
                if (hasFocus) {
                    store.setText("");
                } else {
                    ItemAutocomplete item = Iterables.tryFind(stores, input -> input.getId() == storeId).orNull();
                    if (item != null) {
                        store.setText(item.getLabel());
                    } else {
                        store.setText(getString(R.string.stores_empty));
                    }

                }
            });
        });
        store.setAdapter(storeAdapter);
        store.setOnItemClickListener((parent, view1, position, id) -> {
            ItemAutocomplete data = (ItemAutocomplete) parent.getItemAtPosition(position);
            this.storeId = data.getId();
            hideKeyboard();
        });
        store.setOnClickListener(v -> store.setText(""));
    }

    private void configDepartments(View view) {
        department = view.findViewById(R.id.department);
        CustomArrayAdapter<ItemAutocomplete> departmentAdapter = new CustomArrayAdapter(getContext(), android.R.layout.simple_dropdown_item_1line);
        addTicketViewModel.getDepartments().observe(this, departments -> {
            departmentAdapter.clear();
            departmentAdapter.addAll(departments);
            departmentAdapter.notifyDataSetChanged();
            department.setText(departments.get(0).getLabel());
            departmentId = departments.get(0).getId();
            department.setOnFocusChangeListener((v, hasFocus) -> {
                if (hasFocus) {
                    department.setText("");
                } else {
                    ItemAutocomplete item = Iterables.tryFind(departments, input -> input.getId() == departmentId).orNull();
                    department.setText(item.getLabel());
                }
            });
            addTicketViewModel.setFilterDepartment(departmentId);
        });
        department.setAdapter(departmentAdapter);
        department.setOnItemClickListener((parent, view1, position, id) -> {
            ItemAutocomplete data = (ItemAutocomplete) parent.getItemAtPosition(position);
            departmentId = data.getId();
            addTicketViewModel.setFilterDepartment(departmentId);
            hideKeyboard();
        });
        department.setOnClickListener(v -> department.setText(""));
    }

    private void configUsers(View view) {
        user = view.findViewById(R.id.user);
        CustomArrayAdapter<ItemAutocomplete> userAdapter = new CustomArrayAdapter<>(getContext(), android.R.layout.simple_dropdown_item_1line);
        addTicketViewModel.getUsersDepartment().observe(this, users -> {
            userAdapter.clear();
            userAdapter.addAll(users);
            userAdapter.notifyDataSetChanged();
            if (users != null && users.size() > 0) {
                user.setText(users.get(0).getLabel());
                userId = users.get(0).getId();
                enableView(user);
            } else {
                disableView(user);
                user.setText(getString(R.string.emptyUsers));
                userId = null;
            }
            user.setOnFocusChangeListener((v, hasFocus) -> {
                if (hasFocus) {
                    user.setText("");
                } else {
                    ItemAutocomplete item = Iterables.tryFind(users, input -> input.getId() == userId).orNull();
                    user.setText(item.getLabel());
                }
            });
        });
        user.setAdapter(userAdapter);
        user.setOnItemClickListener((parent, view1, position, id) -> {
            ItemAutocomplete data = (ItemAutocomplete) parent.getItemAtPosition(position);
            userId = data.getId();
            hideKeyboard();
        });
        user.setOnClickListener(v -> user.setText(""));
    }

    private void configDiagnostic(View view) {
        diagnostic = view.findViewById(R.id.diagnostic);
        addTicketViewModel.getDiagnostic().observe(this, diagnosticValue -> {
            diagnostic.setText(diagnosticValue.getLabel());
        });
        addTicketViewModel.setFilterDiagnostic(diagnosticId);
        disableView(diagnostic);
    }

    private void configPlace(View view) {
        place = view.findViewById(R.id.place);
        place.setText(usuarioInfo.getRegionId() + " - " + usuarioInfo.getRegionDesc());
        disableView(place);
    }

    private void configApproved(View view) {
        approved = view.findViewById(R.id.approved);
        approved.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                enableView(comment);
            } else {
                disableView(comment);
                comment.setText("");
            }
        });
    }

    private void configComment(View view) {
        comment = view.findViewById(R.id.comment);
        if (approved.isChecked()) {
            comment.setEnabled(true);
        } else {
            comment.setEnabled(false);
        }
    }

    private void configRegionStates(View view) {
        options = view.findViewById(R.id.options);
        optionStore = view.findViewById(R.id.optStore);
        optionOthers = view.findViewById(R.id.optOther);
        layoutOther = view.findViewById(R.id.layoutOther);
        layoutStore = view.findViewById(R.id.layoutStore);
        layoutStore.setVisibility(View.GONE);
        layoutOther.setVisibility(View.GONE);
        addTicketViewModel.getRegionStates().observe(this, regionStates -> {
            optionOthers.setChecked(regionStates.isOtherChecked());
            optionStore.setChecked(regionStates.isStoreChecked());
            if (regionStates.isOptionEnable()) {
                enableButton(optionOthers);
                enableButton(optionStore);
            } else {
                disableButton(optionOthers);
                disableButton(optionStore);
            }
            if (optionStore.isChecked()) {
                layoutOther.setVisibility(View.GONE);
                layoutStore.setVisibility(View.VISIBLE);
            } else {
                layoutOther.setVisibility(View.VISIBLE);
                layoutStore.setVisibility(View.GONE);
            }
        });
        optionStore.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                layoutOther.setVisibility(View.GONE);
                layoutStore.setVisibility(View.VISIBLE);
            } else {
                layoutOther.setVisibility(View.VISIBLE);
                layoutStore.setVisibility(View.GONE);
            }
        });

    }

    private void saveTicket() {

    }

    private void disableView(View view) {
        view.setEnabled(false);
        view.setClickable(false);
        view.setFocusable(false);
    }

    private void enableView(View view) {
        view.setEnabled(true);
        view.setClickable(true);
        view.setFocusableInTouchMode(true);
        view.setFocusable(true);
    }

    private void enableButton(View view) {
        view.setEnabled(true);
        view.setClickable(true);
    }

    private void disableButton(View view) {
        view.setEnabled(false);
        view.setClickable(false);
    }

    public void hideKeyboard() {
        Activity activity = getActivity();
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
