package mx.com.pelayo.ui.ticket.add;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;

import com.google.common.collect.Iterables;

import javax.inject.Inject;

import mx.com.pelayo.App;
import mx.com.pelayo.R;
import mx.com.pelayo.database.entities.Usuario;
import mx.com.pelayo.database.entities.custom.ItemAutocomplete;
import mx.com.pelayo.database.entities.custom.UsuarioInfo;
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

    private AutoCompleteTextView department;

    private int typeId;
    private int symptomId;
    private int diagnosticId;

    private Integer regionId;
    private Integer applicantId;
    private Integer expertId;
    private Integer districtId;
    private Integer storeId;

    private Integer departmentId;

    private UsuarioInfo usuarioInfo;

    public AddTicketFragment() {
        // Required empty public constructor
    }

    public static AddTicketFragment newInstance(Integer typeId, Integer symptomId, Integer diagnosticId) {
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
        configApplicants(view);
        configRegions(view);
        configExpert(view);
        configDistrict(view);
        configStores(view);
        configDepartments(view);
        return view;
    }

    private void configRegions(View view) {
        region = view.findViewById(R.id.region);
        CustomArrayAdapter<ItemAutocomplete> regionAdapter = new CustomArrayAdapter(getContext(), android.R.layout.simple_dropdown_item_1line);
        addTicketViewModel.getRegions().observe(this, regions -> {
            regionAdapter.clear();
            regionAdapter.addAll(regions);
            regionAdapter.notifyDataSetChanged();
            ItemAutocomplete item = Iterables.tryFind(regions, input -> input.getId() == usuarioInfo.getRegionId()).orNull();
            if (item != null) {
                regionId = item.getId();
                region.setText(item.getLabel());
            } else {
                regionId = regions.get(0).getId();
                region.setText(regions.get(0).getLabel());
            }
            addTicketViewModel.setFilterRegion(regionId);
        });
        region.setAdapter(regionAdapter);
        region.setOnItemClickListener((parent, view1, position, id) -> {
            ItemAutocomplete data = (ItemAutocomplete) parent.getItemAtPosition(position);
            regionId = data.getId();
            addTicketViewModel.setFilterRegion(regionId);
            addTicketViewModel.setExpertParams(new AddTicketViewModel.ExpertParams(departmentId, regionId));

        });
    }

    private void configApplicants(View view) {
        applicant = view.findViewById(R.id.applicant);
        CustomArrayAdapter<Usuario> applicantAdapter = new CustomArrayAdapter(getContext(), android.R.layout.simple_dropdown_item_1line);
        addTicketViewModel.getUsers().observe(this, usuarios -> {
            applicantAdapter.clear();
            applicantAdapter.addAll(usuarios);
            System.out.println(usuarioInfo.getId());
            applicantAdapter.notifyDataSetChanged();
            Usuario item = Iterables.tryFind(usuarios, input -> {
                if (input.getId() == usuarioInfo.getId()) {
                    System.out.println("Si es no ma!!!!!!!!!!!!!!!!");
                }
                return input.getId() == usuarioInfo.getId();
            }).orNull();
            if (item != null) {
                applicant.setText(item.toString());
                applicantId = item.getId();
                departmentId = item.getDepartamentoId();
            } else {
                applicant.setText(usuarios.get(0).toString());
                applicantId = usuarios.get(0).getId();
                departmentId = usuarios.get(0).getDepartamentoId();
            }
            addTicketViewModel.setExpertParams(new AddTicketViewModel.ExpertParams(departmentId, regionId));

        });
        applicant.setAdapter(applicantAdapter);
        applicant.setOnItemClickListener((parent, view1, position, id) -> {
            Usuario data = (Usuario) parent.getItemAtPosition(position);
            this.applicantId = data.getId();
            addTicketViewModel.setExpertParams(new AddTicketViewModel.ExpertParams(data.getDepartamentoId(), regionId));
        });
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
        });
        expert.setAdapter(expertAdapter);
        expert.setOnItemClickListener((parent, view1, position, id) -> {
            ItemAutocomplete data = (ItemAutocomplete) parent.getItemAtPosition(position);
            expertId = data.getId();
        });
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
            this.addTicketViewModel.setFilterDisctrict(districtId);
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
            this.addTicketViewModel.setFilterDisctrict(districtId);
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
        });
        department.setAdapter(departmentAdapter);
        department.setOnItemClickListener((parent, view1, position, id) -> {
            ItemAutocomplete data = (ItemAutocomplete) parent.getItemAtPosition(position);
            departmentId = data.getId();
        });
        department.setOnClickListener(v -> department.setText(""));
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

}
